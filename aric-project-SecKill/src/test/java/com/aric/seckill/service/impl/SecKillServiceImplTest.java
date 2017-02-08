package com.aric.seckill.service.impl;

import com.aric.common.utils.PrinterUtils;
import com.aric.seckill.service.SecKillService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SecKillServiceImplTest extends BaseTest{

  org.slf4j.Logger logger= org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecKillService secKillService;

    @Test
    public void testGetSecKillUrl() throws Exception {
      PrinterUtils.printILog(secKillService.getSecKillUrl(2,1));
    }

    @Test
    public void testExecuteSecKill() throws Exception {
     String ss="";
      PrinterUtils.printILog(secKillService.getSecKillDetailsList());
    }
}