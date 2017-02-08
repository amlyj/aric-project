package com.aric.seckill.mapper;

import com.aric.seckill.entity.SecKillDetails;
import com.aric.seckill.dto.SecKillDetailsDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecKillDetailsMapper {

    public int saveSecKillDetails(@Param("secKillDetails")SecKillDetails secKillDetails);

    public SecKillDetailsDto getSecKillDetailsById(
            @Param("socket")int socket,@Param("account")int account);


    public List<SecKillDetailsDto> getSecKillDetailsList();

}