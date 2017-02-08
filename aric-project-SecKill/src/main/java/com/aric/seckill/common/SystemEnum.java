package com.aric.seckill.common;

/**
 * Created by Administrator on 2016/7/9.
 */
public class SystemEnum {

    public enum RESPONSE_CODE{
        SUCCESS(0),ERROR(1);
        private Integer code;
        public Integer getCode() {
            return code;
        }
        RESPONSE_CODE(Integer code){
            this.code=code;
        }

    }

    public enum SEC_KILL_STATE{
        ERROR(-1),SUCCESS(0),SEND(1),RECEIVE(2);
        private Integer code;
        SEC_KILL_STATE(Integer code){
            this.code=code;
        }
        public Integer getCode() {
            return code;
        }
    }

}
