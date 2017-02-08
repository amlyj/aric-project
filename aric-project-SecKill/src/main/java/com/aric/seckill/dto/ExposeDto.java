package com.aric.seckill.dto;

/**
 * Created by Administrator on 2016/7/9.
 * 暴露秒杀接口地址对象
 */
public class ExposeDto {

    //是否暴露
    private boolean expose;
    //加密
    private String md5;
    //秒杀对象
    private Integer stockId;
    //开始时间
    private Long  start;
    //结束时间
    private Long end;
    //当前时间
    private Long now;


    public boolean isExpose() {
        return expose;
    }

    public void setExpose(boolean expose) {
        this.expose = expose;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public Long getNow() {
        return now;
    }

    public void setNow(Long now) {
        this.now = now;
    }

    @Override
    public String toString() {
        return "ExposeDto{" +
                "expose=" + expose +
                ", md5='" + md5 + '\'' +
                ", stockId='" + stockId + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", now=" + now +
                '}';
    }
    public ExposeDto(boolean expose, Integer stockId) {
        this.expose = expose;
        this.stockId = stockId;
    }
    public ExposeDto(boolean expose, String md5, Integer stockId) {
        this.expose = expose;
        this.md5 = md5;
        this.stockId = stockId;
    }

    public ExposeDto(boolean expose, Integer stockId, Long start, Long end, Long now) {
        this.expose = expose;
        this.stockId = stockId;
        this.start = start;
        this.end = end;
        this.now = now;
    }

    public ExposeDto(boolean expose, String md5, Integer stockId, Long start, Long end, Long now) {
        this.expose = expose;
        this.md5 = md5;
        this.stockId = stockId;
        this.start = start;
        this.end = end;
        this.now = now;
    }

    public ExposeDto() {
    }
}
