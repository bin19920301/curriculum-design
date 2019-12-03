package com.hit.curricelumdesign.utils;

import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.exception.ServiceInvokeFailException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public class HttpConnectionPoolUtils {

	private static Logger logger = LoggerFactory.getLogger(HttpConnectionPoolUtils.class);

	private static CloseableHttpClient httpClient; // 发送请求的客户端单例

	private static PoolingHttpClientConnectionManager manager; //连接池管理类

	private static ScheduledExecutorService monitorExecutor;

	private final static Object syncLock = new Object(); // 相当于线程锁,用于线程安全

	static final int timeOut = 10 * 1000;

	private static void config(HttpRequestBase httpRequestBase) {
		// 配置请求的超时设置
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(timeOut)
				.setConnectTimeout(timeOut).setSocketTimeout(timeOut).build();
		httpRequestBase.setConfig(requestConfig);
	}

	/**
	 * 获取HttpClient对象
	 *
	 * @param url
	 * @return
	 */
	public static CloseableHttpClient getHttpClient(String url) {
		String hostname = url.split("/")[2];
		int port = 80;
		if (hostname.contains(":")) {
			String[] arr = hostname.split(":");
			hostname = arr[0];
			port = Integer.parseInt(arr[1]);
		}
		if (httpClient == null) {
			synchronized (syncLock) {
				if (httpClient == null) {
					httpClient = createHttpClient(200, 40, 100, hostname, port);
				}
			}
		}
		return httpClient;
	}

	/**
	 * 创建HttpClient对象
	 *
	 * @param maxTotal
	 * @param maxPerRoute
	 * @param maxRoute
	 * @param hostname
	 * @param port
	 * @return
	 * @throws ServiceInvokeFailException
	 */
	public static CloseableHttpClient createHttpClient(int maxTotal, int maxPerRoute, int maxRoute, String hostname,
			int port) throws ServiceInvokeFailException {
		ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
		LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory.getSocketFactory();
		Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory> create()
				.register("http", plainsf).register("https", sslsf).build();
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
		// 将最大连接数增加
		cm.setMaxTotal(maxTotal);
		// 将每个路由基础的连接增加
		cm.setDefaultMaxPerRoute(maxPerRoute);
		HttpHost httpHost = new HttpHost(hostname, port);
		// 将目标主机的最大连接数增加
		cm.setMaxPerRoute(new HttpRoute(httpHost), maxRoute);

		// 请求重试处理
		HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
			public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
				if (executionCount >= 5) {// 如果已经重试了5次，就放弃
					return false;
				}
				if (exception instanceof NoHttpResponseException) {// 如果服务器丢掉了连接，那么就重试
					return true;
				}
				if (exception instanceof SSLHandshakeException) {// 不要重试SSL握手异常
					return false;
				}
				if (exception instanceof InterruptedIOException) {// 超时
					return false;
				}
				if (exception instanceof UnknownHostException) {// 目标服务器不可达
					return false;
				}
				if (exception instanceof ConnectTimeoutException) {// 连接被拒绝
					return false;
				}
				if (exception instanceof SSLException) {// SSL握手异常
					return false;
				}

				HttpClientContext clientContext = HttpClientContext.adapt(context);
				HttpRequest request = clientContext.getRequest();
				// 如果请求是幂等的，就再次尝试
				if (!(request instanceof HttpEntityEnclosingRequest)) {
					return true;
				}
				return false;
			}
		};

		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm)
				.setRetryHandler(httpRequestRetryHandler).build();

		return httpClient;
	}

	/**
	 * 设置post请求的参数
	 *
	 * @param httpPost
	 * @param params
	 */
	private static void setPostParams(HttpPost httpPost, Map<String, String> params) {
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		Set<String> keys = params.keySet();
		for (String key : keys) {
			nvps.add(new BasicNameValuePair(key, params.get(key)));
		}
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置请求头
	 *
	 * @param httpPost
	 * @param headers
	 */
	private static void setPostHeaders(HttpPost httpPost, Map<String, String> headers) {
		if (null != headers) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				httpPost.setHeader(entry.getKey(), entry.getValue());
			}
		}
	}

	/**
	 * 发送post请求
	 *
	* @throws IOException
	* @throws ClientProtocolException  POST
	* @Title: post
	* @Description:
	* @param @param url
	* @param @param params
	* @param @return
	* @return JsonObject
	* @throws
	*/
	public static String post(String url, Map<String, String> params, Map<String, String> headers)
			throws ServiceInvokeFailException {
		HttpPost httpPost = new HttpPost(url);
		config(httpPost);
		setPostParams(httpPost, params);
		setPostHeaders(httpPost, headers);
		CloseableHttpResponse response = null;
		String result = "";
		try {
			response = getHttpClient(url).execute(httpPost, HttpClientContext.create());

			HttpEntity responseEntity = response.getEntity();

			result = EntityUtils.toString(responseEntity, Constants.Common.DEFAULT_CHARSET_NAME);

			logger.info("[POST]url=" + url + " params=" + params + ", response=" + result);
		} catch (ClientProtocolException e) {
			logger.error(String.format("请求异常，url=%s ,params=%s,异常为=%s", url, params, ExceptionUtils.getStackTrace(e)));
			throw new ServiceInvokeFailException();
		} catch (IOException e) {
			logger.error(String.format("请求异常，url=%s ,params=%s,异常为=%s", url, params, ExceptionUtils.getStackTrace(e)));
			throw new ServiceInvokeFailException();
		}

		return result;
	}

	/**
	 * 发起post请求
	 *
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String post(String url, Map<String, String> params) throws ServiceInvokeFailException {
		return post(url, params, null);
	}

	/**
	 * 发起post请求
	 *
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String post(String url, String entity) throws ServiceInvokeFailException {
		return post(url, entity, null);
	}

	/**
	 * 发起post请求
	 *
	 * @param url
	 * @param headers
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 * @throws Exception
	 */
	public static String post(String url, String entity, Map<String, String> headers)
			throws ServiceInvokeFailException {
		CloseableHttpResponse response = null;
		HttpPost httpPost = new HttpPost(url);
		setPostHeaders(httpPost, headers);

		StringEntity stringEntity = new StringEntity(entity, Constants.Common.DEFAULT_CHARSET_NAME);

		httpPost.setEntity(stringEntity);

		logger.info("[POST]url=" + url + ", request stringEntity=" + stringEntity);

		String result = "";
		try {
			response = getHttpClient(url).execute(httpPost, HttpClientContext.create());

			HttpEntity responseEntity = response.getEntity();

			result = EntityUtils.toString(responseEntity, Constants.Common.DEFAULT_CHARSET_NAME);

			logger.info("[POST]url=" + url + ", response=" + result);

		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new ServiceInvokeFailException();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ServiceInvokeFailException();
		}

		return result;
	}

	/**
	 * 去除url中的协议
	 *
	 * @param url
	 * @return
	 */
	public static String removeUrlProtocol(String url) {
		if (StringUtil.isBlank(url)) {
			return url;
		}

		if (url.startsWith("http:")) {
			return url.replaceFirst("http:", "");
		}

		if (url.startsWith("https:")) {
			return url.replaceFirst("https:", "");
		}

		return url;
	}

	/**
	 * 关闭连接池
	 */
	public static void closeConnectionPool() {
		try {
			httpClient.close();
			manager.close();
			monitorExecutor.shutdown();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
