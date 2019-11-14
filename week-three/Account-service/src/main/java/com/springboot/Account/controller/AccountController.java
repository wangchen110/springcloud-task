package com.springboot.Account.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.Account.domain.Account;
import com.springboot.Account.domain.Dateil;
import com.springboot.Account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <br>Title: AccountController
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/9/14:59
 */
@RestController
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/listDateil")
    public List<Dateil> listDateil(@RequestParam(value = "typeId", defaultValue = "1") Integer typeId) {
        return accountService.listDateils(typeId);
    }

    @PostMapping("/saveAccount")
    public boolean saveAccount(@RequestBody Account account) {
        return accountService.saveAccount(account)>0;
    }


    @GetMapping("/list")
    public Map<String,Object> list(Account account, @RequestParam(defaultValue = "1",value ="pageNum" ) Integer pageNum, @RequestParam(defaultValue = "3",value = "pageSize") Integer pageSize)
    {
        return accountService.list(account,pageNum,pageSize);
    }

    @Value("${file.path}")
    private String filePath;

    @RequestMapping("/upload")
    public String iupload(MultipartFile file) {
        System.out.println(file);
        String newName="";
        if(file!=null)
        {
            try {
                String oldName = file.getOriginalFilename();
                String suffix = oldName.substring(oldName.lastIndexOf("."));
                newName = UUID.randomUUID().toString()+suffix;
                file.transferTo(new File(filePath+newName));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return filePath+newName;
    }
}
