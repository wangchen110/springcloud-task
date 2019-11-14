package com.springboot.Account.service;

import com.github.pagehelper.PageInfo;
import com.springboot.Account.domain.Account;
import com.springboot.Account.domain.Dateil;

import java.util.List;
import java.util.Map;

public interface AccountService {

    List<Dateil> listDateils(Integer typeId);

    int saveAccount(Account account);

    Map<String,Object> list(Account account, Integer pageNum, Integer pageSize);
}
