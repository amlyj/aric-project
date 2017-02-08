package com.aric.seckill.exception;

/**
 * 秒杀异常类
 * Created by Administrator on 2016/7/9.
 */
public class SecKillException extends RuntimeException {
    public SecKillException(String message) {
        super(message);
    }

    public SecKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
