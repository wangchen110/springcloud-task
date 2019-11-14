package com.springboot.Account.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.Account.dao.AccountDao;
import com.springboot.Account.domain.Account;
import com.springboot.Account.domain.Dateil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <br>Title: AccountServiceImpl
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/9/15:46
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Dateil> listDateils(Integer typeId) {
        return accountDao.listType(typeId);
    }

    @Override
    public int saveAccount(Account account) {
        return accountDao.saveAccount(account);
    }

    @Override
    public  Map<String,Object> list(Account account,Integer pageNum,Integer pageSize) {
        Map<String,Object> map = new HashMap();
        Integer expenditure = accountDao.getExpenditurePrice(account,1);
        Integer income = accountDao.getExpenditurePrice(account,0);
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(accountDao.list(account));
        map.put("pageInfo",pageInfo);
        map.put("expenditure",expenditure);
        map.put("income",income);
        return map;
    }
}
