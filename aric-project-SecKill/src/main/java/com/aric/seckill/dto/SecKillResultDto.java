package com.aric.seckill.dto;

/**
 * 执行秒杀后返回结果
 * Created by Administrator on 2016/7/9.
 */
public class SecKillResultDto {

    //秒杀对象
    private Integer stockId;
    //秒杀状态
    private int code;
    //提示
    private String message;
    //秒杀详情对象
    private SecKillDetailsDto secKillDetailsDto;


    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SecKillDetailsDto getSecKillDetailsDto() {
        return secKillDetailsDto;
    }

    public void setSecKillDetailsDto(SecKillDetailsDto secKillDetailsDto) {
        this.secKillDetailsDto = secKillDetailsDto;
    }

    public SecKillResultDto(Integer stockId, int code, String message, SecKillDetailsDto secKillDetailsDto) {
        this.stockId = stockId;
        this.code = code;
        this.message = message;
        this.secKillDetailsDto = secKillDetailsDto;
    }

    public SecKillResultDto(Integer stockId, int code, String message) {
        this.stockId = stockId;
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "SecKillResultDto{" +
                "stockId=" + stockId +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", secKillDetailsDto=" + secKillDetailsDto +
                '}';
    }
}
