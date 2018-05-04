package com.dcit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.dcit.common.mapper.SysMapper;
import com.dcit.pojo.Bankcard;

public interface BankcardMapper extends SysMapper<Bankcard> {
	@Update("update t_bankcard set balance=balance+#{newbalance} Where cardno=#{cardcode}")
    void updateBalanceByCode(@Param("cardcode")String cardcode,@Param("newbalance")Double newbalance);

}
