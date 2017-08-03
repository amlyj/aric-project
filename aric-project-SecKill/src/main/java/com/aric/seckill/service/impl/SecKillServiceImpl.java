package com.aric.seckill.service.impl;

import com.aric.common.utils.StringUtils;
import com.aric.seckill.common.SystemEnum;
import com.aric.seckill.dto.ExposeDto;
import com.aric.seckill.dto.SecKillDetailsDto;
import com.aric.seckill.dto.SecKillResultDto;
import com.aric.seckill.entity.SecKillDetails;
import com.aric.seckill.entity.Stock;
import com.aric.seckill.exception.RepeatSecKillException;
import com.aric.seckill.exception.SecKillException;
import com.aric.seckill.exception.StopSecKillException;
import com.aric.seckill.mapper.SecKillDetailsMapper;
import com.aric.seckill.mapper.StockMapper;
import com.aric.seckill.service.SecKillService;
import com.aric.seckill.common.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/7/9.
 */
@Service
@Transactional
public class SecKillServiceImpl implements SecKillService {

    @Autowired
    private SecKillDetailsMapper secKillDetailsMapper;

    @Autowired
    private StockMapper stockMapper;


    @Override
    public int saveSecKillDetails(SecKillDetails secKillDetails) {
        return secKillDetailsMapper.saveSecKillDetails(secKillDetails);
    }

    @Override
    public SecKillDetailsDto getSecKillDetailsById(int socket, int account) {
        return secKillDetailsMapper.getSecKillDetailsById(socket, account);
    }

    @Override
    public List<SecKillDetailsDto> getSecKillDetailsList() {
        return secKillDetailsMapper.getSecKillDetailsList();
    }

    @Override
    public Stock getStockById(Integer id) {
        return stockMapper.getStockById(id);
    }

    @Override
    public List<Stock> getStockList() {
        return stockMapper.getStockList();
    }

    @Override
    public ExposeDto getSecKillUrl(Integer stockId,Integer accountId) {
        Stock stock=getStockById(stockId);
        if(stock==null){
            return new ExposeDto(false,stockId);
        }
        Long start=stock.getStartTime().getTime();
        Long end=stock.getEndTime().getTime();
        Long currentTime=(new Date()).getTime();
        if(currentTime<start||currentTime>end){
            return new ExposeDto(false,stockId,start,end,currentTime);
        }
        return new ExposeDto(true,md5Code(stockId,accountId),stockId);

    }

    /**
     * 先执行insert－再执行update,以减少行级锁持有时间．提高并发量．
     * @param stockId
     * @param accountId
     * @param md5
     * @return
     */
    @Override
    public SecKillResultDto executeSecKill(Integer stockId, Integer accountId, String md5)
            throws SecKillException, RepeatSecKillException, StopSecKillException {
        if(StringUtils.isEmpty(md5)||!md5.equals(md5Code(stockId,accountId))){
            throw new SecKillException("request data is illegal for executeSecKill");
        }
        Date currentTime=new Date();
        try {
            SecKillDetails secKillDetails=new SecKillDetails(stockId,accountId,
                    SystemEnum.SEC_KILL_STATE.SUCCESS.getCode(),currentTime);
            int secKillNumber=secKillDetailsMapper.saveSecKillDetails(secKillDetails);
            if(secKillNumber<=0){
                throw new RepeatSecKillException("RepeatSecKillException : executeSecKill error");
            }else {
                int reduceNumber=stockMapper.reduceStock(stockId,currentTime);
                if(reduceNumber<=0){
                    throw new StopSecKillException("executeSecKill stop");
                }else {
                    SecKillDetailsDto secKillDetailsDto=secKillDetailsMapper.
                            getSecKillDetailsById(stockId,accountId);
                    return new SecKillResultDto(stockId,
                            SystemEnum.SEC_KILL_STATE.SUCCESS.getCode(),
                            "success",
                            secKillDetailsDto);
                }
            }

        }catch (StopSecKillException e){
            throw e;
        }catch (RepeatSecKillException e){
            throw e;
        }catch (Exception e){
            throw new SecKillException("executeSecKill error "+e);
        }
    }


    /**
     * md5 convert
     * @param stockId
     * @return
     */
    private String md5Code(Integer stockId,Integer accountId){
        String base=stockId+Constant.SLAT+accountId;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

}
