package com.hit.curricelumdesign.utils;

import com.hit.curricelumdesign.context.response.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Description: 响应处理工具
 * ClassName: RequestUtils
 * date: 2018年11月11日
 *
 * @author YGC
 * @version
 * @since JDK 1.8
 */
public class ResponseUtils {

	private static final Log logger = LogFactory.getLog(ResponseUtils.class);

	/**
	 * 根据用户端接受的文件格式，生成对应的格式
	 *
	 * @param request
	 * @param result
	 * @return
	 */
	public static String getResponseContent(HttpServletRequest request, Result result) {
		// 获取客户端能够接收的数据格式
		String content = GsonUtils.getInstace().toJson(result);
		return content;
	}

	/**
	 * 向客户端输出内容
	 *
	 * @param response
	 * @param content
	 */
	public static void writer(HttpServletResponse response, String content) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(content);
			out.flush();
		} catch (IOException e) {
			logger.error(LogUtils.getCommLog(String.format("响应客户端出错:%s", e.getMessage())));
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					logger.error(LogUtils.getCommLog(String.format("关闭输出流出错:%s", e.getMessage())));
				}
			}
		}
	}

	/**
	 * 向客户端输出图片
	 *
	 * @param response
	 * @param bufferedImage
	 */
	public static void writer(HttpServletResponse response, BufferedImage bufferedImage) {
		response.setContentType("image/jpeg");
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		ServletOutputStream outPutStream = null;
		try {
			outPutStream = response.getOutputStream();
			ImageIO.write(bufferedImage, "jpg", outPutStream);
			outPutStream.flush();
		} catch (IOException e) {
			logger.error(LogUtils.getCommLog(String.format("响应客户端出错:%s", e.getMessage())));
		} finally {
			if (outPutStream != null) {
				try {
					outPutStream.close();
				} catch (Exception e) {
					logger.error(LogUtils.getCommLog(String.format("关闭输出流出错:%s", e.getMessage())));
				}
			}
		}
	}

}
