package com.dcit.mapper;

import com.dcit.common.mapper.SysMapper;
import com.dcit.common.vo.Where;
import com.dcit.pojo.CLLoan;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CLLoanMapper extends SysMapper<CLLoan>{

    int deleteByPrimaryKey(String loanid);

    int insert(CLLoan record);

    @Select("select * from t_loan")
    List<CLLoan> findAll();
    
    @Select("select * from t_loan where loanid=#{loanid}")
    CLLoan findOne(@Param("loanid")String loanid);
    
    @Select("select * from t_loan where loancode=#{loancode}")
    CLLoan findOneBycode(@Param("loancode")String loancode);
    
    @Update("update t_loan set balance=#{newbalance} Where loancode=#{loancode}")
    void updateBalanceByCode(@Param("newbalance")Double newbalance,@Param("loancode")String loancode);

    CLLoan selectByPrimaryKey(String loanid);

    int updateByPrimaryKeySelective(CLLoan record);

    int updateByPrimaryKey(CLLoan record);
}