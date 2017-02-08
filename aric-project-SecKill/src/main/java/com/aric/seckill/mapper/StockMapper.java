package com.aric.seckill.mapper;

import com.aric.seckill.entity.Stock;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StockMapper{

    /**
     * 减库存
     * @param id
     * @param reduceTime
     * @return
     */
    public int reduceStock(@Param("id")Integer id,@Param("reduceTime")Date reduceTime);

    /**
     * 根据id 查询秒杀对象
     * @param id
     * @return
     */
    public Stock getStockById(Integer id);


    /**
     * 库存列表
     * @return
     */
    public List<Stock> getStockList();
}