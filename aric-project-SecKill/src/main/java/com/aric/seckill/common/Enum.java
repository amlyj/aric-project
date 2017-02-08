package com.aric.seckill.common;

import com.aric.common.utils.PrinterUtils;

/**
 * Created by Administrator on 2016/7/9.
 */
public class Enum {
    public  enum  MessageInfo{
        SUCCESS(1,"成功"),
        ERROR(0,"失败");


        private int state;
        private String message;

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        MessageInfo(int state, String message) {
            this.state = state;
            this.message = message;
        }

        public static MessageInfo valueOf(int index){
            for (MessageInfo ms:values()){
                if(ms.getState()==index){
                    return ms;
                }
            }return null;
        }
    }


    public static void main(String[] args) {
        PrinterUtils.printILog(MessageInfo.SUCCESS);
    }


}
