package com.aric.seckill.service;

import com.aric.seckill.entity.Account;

/**
 * Created by Administrator on 2016/7/9.
 */
public interface LoginService {

    public Account login(String username,String password);
}
