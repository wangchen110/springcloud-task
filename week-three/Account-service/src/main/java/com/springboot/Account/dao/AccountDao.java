package com.springboot.Account.dao;

import com.springboot.Account.domain.Account;
import com.springboot.Account.domain.Dateil;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AccountDao {

    @Select("select * from Account_detail where typeId = #{typeId}")
    List<Dateil> listType(@Param("typeId") Integer typeId);

    @Insert("insert into Account(price,types,note,imgurl,created) value(#{price},#{types},#{note},#{imgurl},#{created})")
    int saveAccount(Account account);

    List<Account> list(Account account);

    Integer getExpenditurePrice(@Param("account") Account account,@Param("id") Integer id);
}
