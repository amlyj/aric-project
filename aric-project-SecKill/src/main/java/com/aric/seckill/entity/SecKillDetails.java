package com.aric.seckill.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_seckill_details")
public class SecKillDetails {
    @Id
    @Column(name = "stock_id")
    private Integer stockId;

    @Id
    @Column(name = "account_id")
    private Integer accountId;

    /**
     * -1,无效，0,成功，1，发货，2,签收
     */
    private Integer state;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return stock_id
     */
    public Integer getStockId() {
        return stockId;
    }

    /**
     * @param stockId
     */
    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    /**
     * @return account_id
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * @param accountId
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取-1,无效，0,成功，1，发货，2,签收
     *
     * @return state - -1,无效，0,成功，1，发货，2,签收
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置-1,无效，0,成功，1，发货，2,签收
     *
     * @param state -1,无效，0,成功，1，发货，2,签收
     */
    public void setState(Integer state) {
        this.state = state;
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

    public SecKillDetails(Integer stockId, Integer accountId, Integer state, Date createTime) {
        this.stockId = stockId;
        this.accountId = accountId;
        this.state = state;
        this.createTime = createTime;
    }

    public SecKillDetails() {
    }
}