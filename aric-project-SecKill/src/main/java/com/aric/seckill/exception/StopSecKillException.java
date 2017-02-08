package com.aric.seckill.exception;

/**
 * 结束秒杀异常
 * Created by Administrator on 2016/7/9.
 */
public class StopSecKillException extends SecKillException {


    public StopSecKillException(String message) {
        super(message);
    }

    public StopSecKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
