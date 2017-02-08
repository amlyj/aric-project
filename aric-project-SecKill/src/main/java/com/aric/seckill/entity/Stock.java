package com.aric.seckill.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_stock")
public class Stock {
    /**
     * 库存表
     */
    @Id
    @Column(name = "stock_id")
    private Integer stockId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品数量
     */
    private Integer number;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "create_time")
    private Date createTime;

    private String describe;

    /**
     * 获取库存表
     *
     * @return stock_id - 库存表
     */
    public Integer getStockId() {
        return stockId;
    }

    /**
     * 设置库存表
     *
     * @param stockId 库存表
     */
    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    /**
     * 获取商品名称
     *
     * @return name - 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品名称
     *
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取商品数量
     *
     * @return number - 商品数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置商品数量
     *
     * @param number 商品数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @return start_time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return describe
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * @param describe
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                ", describe='" + describe + '\'' +
                '}';
    }
}