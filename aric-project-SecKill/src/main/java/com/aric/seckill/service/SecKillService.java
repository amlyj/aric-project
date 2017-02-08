package com.aric.seckill.service;

import com.aric.seckill.dto.ExposeDto;
import com.aric.seckill.dto.SecKillDetailsDto;
import com.aric.seckill.dto.SecKillResultDto;
import com.aric.seckill.entity.SecKillDetails;
import com.aric.seckill.entity.Stock;
import com.aric.seckill.exception.RepeatSecKillException;
import com.aric.seckill.exception.SecKillException;
import com.aric.seckill.exception.StopSecKillException;

import java.util.List;

/**
 * Created by Administrator on 2016/7/9.
 */
public interface SecKillService {

    /**
     * 保存秒杀记录
     * @param secKillDetails
     * @return
     */
    public int saveSecKillDetails(SecKillDetails secKillDetails);

    /*
     *秒杀记录详情
     */
    public SecKillDetailsDto getSecKillDetailsById(int socket,int account);


    /**
     * 获取秒杀详情列表
     * @return
     */
    public List<SecKillDetailsDto> getSecKillDetailsList();

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


    /**
     * 获取暴露的秒杀接口
     * @param stockId
     * @return
     */
    public ExposeDto getSecKillUrl(Integer stockId,Integer accountId);


    /**
     *
     * 执行秒杀
     * @param stockId 秒杀对象
     * @param accountId 用户
     * @param md5 加密值
     * @return
     * @throws SecKillException
     * @throws RepeatSecKillException
     * @throws StopSecKillException
     */
    public SecKillResultDto executeSecKill(Integer stockId,Integer accountId,String md5)
    throws SecKillException,RepeatSecKillException,StopSecKillException;

}
