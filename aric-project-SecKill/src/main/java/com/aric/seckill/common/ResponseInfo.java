package com.aric.seckill.common;

/**
 * Created by Administrator on 2016/7/9.
 * 响应实体规范
 */
public class ResponseInfo {

    public ResponseInfo(boolean status,Integer code,String message,Object data){
        this.status=status;
        this.code=code;
        this.message=message;
        this.data=data;
    }

    public ResponseInfo(boolean status, Integer code, String message, Integer responseCode) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.responseCode = responseCode;
    }

    public ResponseInfo(boolean status, Integer code, Integer responseCode,String message,  Object data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.responseCode = responseCode;
        this.data = data;
    }

    //是否成功！
    private boolean status;
    //响应状态码0失败,1成功
    private Integer code;
    //响应提示
    private String message;
    //接口定义状态
    private Integer responseCode;
    //响应数据
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



}
