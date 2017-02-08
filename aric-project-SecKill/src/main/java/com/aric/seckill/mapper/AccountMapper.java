package com.aric.seckill.mapper;

import com.aric.seckill.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper{

    @Select("select * from t_account " +
            "where " +
            "username=#{username} and " +
            "password=#{password}")
    public Account login(@Param("username") String username,@Param("password")String password);

}