package com.hit.curricelumdesign.context.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hit.curricelumdesign.context.enums.Error;

/**
 * Description: 响应结果
 * ClassName: Result
 * date: 2018年11月11日
 *
 * @author YGC
 * @since JDK 1.8
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Result {

    /**
     * 响应状态
     */
    private Status status;

    /**
     * 响应结果
     */
    private Object result;

    public Result() {
        this(null);
    }

    public Result(Object result) {
        status = new Status();
        this.result = result;
    }

    public Result(String code, String description) {
        this(code, description, null);
    }

    public Result(String code, String description, Object result) {
        this(new Status(code, description), result);
    }

    public Result(Status status, Object result) {
        this.status = status;
        this.result = result;
    }

    /**
     * 返回成功的对象
     *
     * @return Result
     */
    public static Result success() {
        return new Result(null);
    }

    /**
     * 返回成功的对象
     *
     * @param data
     * @return Result
     */
    public static Result success(Object data) {
        return new Result(data);
    }

    /**
     * 返回失败对象
     *
     * @param error
     * @return Result
     */
    public static Result failure(Error error) {
        return new Result(error.getErrorCode(), error.getErrorMsg());
    }

    /**
     * 返回失败对象
     *
     * @param error
     * @param data
     * @return Result
     */
    public static Result failure(Error error, Object data) {
        return new Result(error.getErrorCode(), error.getErrorMsg(), data);
    }

    /**
     * 返回失败对象
     *
     * @param errorCode
     * @return Result
     */
    public static Result failure(String errorCode) {
        return new Result(Error.code(errorCode), Error.msg(errorCode));
    }

    /**
     * 返回失败对象
     *
     * @param errorCode
     * @param errorMsg
     * @return Result
     */
    public static Result failure(String errorCode, String errorMsg) {
        return new Result(errorCode, errorMsg);
    }

    /**
     * 返回失败对象
     *
     * @param errorCode
     * @param errorMsg
     * @return Result
     */
    public static Result failureWithMsg(String errorCode, String errorMsg) {
        return new Result(Error.code(errorCode), errorMsg + Error.msg(errorCode));
    }

    /**
     * 返回失败对象
     *
     * @param error
     * @param errorMsg
     * @return Result
     */
    public static Result failureWithMsg(Error error, String errorMsg) {
        return new Result(error.getErrorCode(), errorMsg + error.getErrorMsg());
    }

    /**
     * 处理返回对象
     *
     * @param flag
     * @param data
     * @param error
     * @return Result
     */
    public static Result handleResult(boolean flag, Error error) {
        return flag ? Result.success(new Object()) : Result.failure(error);
    }

    /**
     * 处理返回对象
     *
     * @param flag
     * @param error
     * @return Result
     */
    public static Result handleResult(int flag, Error error) {
        return handleResult(flag, new Object(), error);
    }

    /**
     * 处理返回对象
     *
     * @param flag
     * @param data
     * @param error
     * @return Result
     */
    public static Result handleResult(boolean flag, Object data, Error error) {
        return flag ? Result.success(data) : Result.failure(error);
    }

    /**
     * 处理返回对象
     *
     * @param flag
     * @param error
     * @return Result
     */
    public static Result handleResult(int flag, Object data, Error error) {
        return handleResult(flag > 0, data, error);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Result [status=" + status + ", result=" + result + "]";
    }

}
