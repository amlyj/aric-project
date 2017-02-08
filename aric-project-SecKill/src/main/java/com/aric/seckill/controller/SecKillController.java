package com.aric.seckill.controller;

import com.aric.seckill.common.ResponseInfo;
import com.aric.seckill.common.SystemEnum;
import com.aric.seckill.dto.ExposeDto;
import com.aric.seckill.dto.SecKillResultDto;
import com.aric.seckill.entity.Account;
import com.aric.seckill.entity.Stock;
import com.aric.seckill.exception.RepeatSecKillException;
import com.aric.seckill.exception.SecKillException;
import com.aric.seckill.exception.StopSecKillException;
import com.aric.seckill.service.SecKillService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * restful 访问接口 直接返回view ,携带model数据
 * restful ajax 接口，返回responseBody
 * Created by Administrator on 2016/7/10.
 */
@Controller
@RequestMapping("/")
public class SecKillController {

    private static Logger logger= LoggerFactory.getLogger(SecKillController.class);

    @Autowired
    private SecKillService secKillService;

    /**
     * @return
     */
    @RequestMapping(value = "list/stock", method = RequestMethod.GET)
    public String getStockList(Model model) {
        model.addAttribute("stocks", secKillService.getStockList());
        return "stockList";
    }

    @RequestMapping(value = "{stockId}/stock",method = RequestMethod.GET)
    public String getStockInfo(Model model,@PathVariable("stockId")Integer stockId){
        model.addAttribute("stock",secKillService.getStockById(stockId));
        return "stockInfo";
    }
    /**
     * 获取秒杀详情列表
     *
     * @return
     */
    @RequestMapping(value = "list/secKillDetails", method = RequestMethod.GET)
    public String getSecKillDetails(Model model) {
        model.addAttribute("secKillDetails", secKillService.getSecKillDetailsList());
        return "secKillDetails";
    }


    /**
     * 获取秒杀结果详情
     * @param stockId
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "{stockId}/secKillDetail", method = RequestMethod.GET)
    public String getSecKillDetailInfo(@PathVariable("stockId") Integer stockId, Model model,
                                       HttpSession session) {
        model.addAttribute("secKillDetail", secKillService.
                getSecKillDetailsById(stockId,
                        ((Account) session.getAttribute("currentUser")).getId()));
        return "secKillDetailInfo";
    }


    /**
     *获取秒杀地址
     * @param stockId
     * @param session
     * @return
     */
    @RequestMapping(value = "{stockId}/secKillUrl", method = RequestMethod.POST)
    @ResponseBody
    public ResponseInfo getSecKillUrl(@PathVariable("stockId") Integer stockId,
                                      HttpSession session) {
        try {
            ExposeDto exposeDto = secKillService.getSecKillUrl(stockId,
                    ((Account) session.getAttribute("currentUser")).getId());
            return new ResponseInfo(true, SystemEnum.RESPONSE_CODE.SUCCESS.getCode(), "", exposeDto);
        }catch (Exception e){
            logger.info("getSecKillUrl:",e.getMessage());
            return new ResponseInfo(false, SystemEnum.RESPONSE_CODE.ERROR.getCode(), "",null);
        }




    }

    /**
     * 执行秒杀
     * @param stockId
     * @param md5
     * @param session
     * @return
     */
    @RequestMapping(value = "{md5}/executeSecKill", method = RequestMethod.POST)
    @ResponseBody
    public ResponseInfo executeSecKill(Integer stockId, @PathVariable("md5") String md5,
                                       HttpSession session) {
        try {
            SecKillResultDto secKillResultDto = secKillService.
                    executeSecKill(stockId, ((Account) session.
                            getAttribute("currentUser")).getId(), md5);
            return new ResponseInfo(true,
                    SystemEnum.RESPONSE_CODE.SUCCESS.getCode(),
                    SystemEnum.SEC_KILL_STATE.SUCCESS.getCode(),
                    "秒杀成功！", secKillResultDto);
        } catch (StopSecKillException e) {
            logger.info("executeSecKill StopSecKillException:",e.getMessage());
            return new ResponseInfo(false,
                    SystemEnum.RESPONSE_CODE.ERROR.getCode(),
                    SystemEnum.SEC_KILL_STATE.ERROR.getCode(),
                    "秒杀结束！", null);
        } catch (RepeatSecKillException e) {
            logger.info("executeSecKill RepeatSecKillException:",e.getMessage());
            return new ResponseInfo(false,
                    SystemEnum.RESPONSE_CODE.ERROR.getCode(),
                    SystemEnum.SEC_KILL_STATE.ERROR.getCode(),
                    "不能重复秒杀！", null);
        } catch (Exception e) {
            logger.info("executeSecKill Exception:",e.getMessage());
            return new ResponseInfo(false,
                    SystemEnum.RESPONSE_CODE.ERROR.getCode(),
                    SystemEnum.SEC_KILL_STATE.ERROR.getCode(),
                    "内部错误", null);
        }
    }


    /**
     * 获取系统时间
     * @return
     */
    @RequestMapping(value = "now/time" ,method = RequestMethod.GET)
    @ResponseBody
    public ResponseInfo getTime(){
        return new ResponseInfo(true,
                SystemEnum.RESPONSE_CODE.SUCCESS.getCode(),
                "系统时间获取成功！",(new Date().getTime()));
    }

}
