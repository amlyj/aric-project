package com.aric.seckill.dto;

import com.aric.seckill.entity.Account;
import com.aric.seckill.entity.Stock;

import java.util.Date;


/**
 *对entity实体的数据封装
 */
public class SecKillDetailsDto {
    //联合查询
    private Stock stock;
    //联合查询
    private Account account;

    /**
     * -1,无效，0,成功，1，发货，2,签收
     */
    private Integer state;

    private Date createTime;


    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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


    @Override
    public String toString() {
        return "SecKillDetailsVo{" +
                "stock=" + stock +
                ", account=" + account +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }
}