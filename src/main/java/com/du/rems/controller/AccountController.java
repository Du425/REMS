package com.du.rems.controller;


import com.du.rems.entity.Account;
import com.du.rems.mapper.AccountMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Du425
 * @since 2021-10-31
 */
@Controller
@RequestMapping("/account")
@Api(tags = "账户管理")
public class AccountController {
    @Autowired
    private AccountMapper accountMapper;

    @GetMapping("/queryAccountList")
    public List<Account> queryAccountList(){
        return accountMapper.selectList(null);
    }
    @GetMapping("/addAccount")
    public String addAccount(@RequestBody Account account){
        accountMapper.insert(account);
        return "success";
    }
    @GetMapping("/deleteAccount")
    public String deleteAccount(@RequestParam int id){
        if (accountMapper.deleteById(id) == 1) {
            return "ok";
        } else {
            return "fail";
        }
    }
    @GetMapping("/updateAccount")
    public String updateAccount(@RequestBody Account account){
        accountMapper.updateById(account);
        return "ok";
    }
    @GetMapping("/queryAccountById")
    public Account queryAccountById(@RequestParam int id){
        return accountMapper.selectById(id);
    }

}

