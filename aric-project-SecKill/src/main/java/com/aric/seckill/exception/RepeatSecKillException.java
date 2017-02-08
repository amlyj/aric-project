package com.aric.seckill.exception;

/**
 * 重复秒杀异常
 * Created by Administrator on 2016/7/9.
 */
public class RepeatSecKillException extends SecKillException {
    public RepeatSecKillException(String message) {
        super(message);
    }

    public RepeatSecKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
