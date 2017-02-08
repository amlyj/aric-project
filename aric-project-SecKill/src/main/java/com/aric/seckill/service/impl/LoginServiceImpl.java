package com.aric.seckill.service.impl;

import com.aric.seckill.entity.Account;
import com.aric.seckill.mapper.AccountMapper;
import com.aric.seckill.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/7/9.
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account login(String username, String password) {
        return accountMapper.login(username, password);
    }
}
