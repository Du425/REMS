package com.du.rems.controller;


import com.du.rems.entity.Account;
import com.du.rems.mapper.AccountMapper;
import com.du.rems.response.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Du425
 * @since 2021-11-06
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountMapper accountMapper;

    @GetMapping("/queryAccountList")
    public CommonResult queryAccountList(){
        List<Account> accountList = accountMapper.queryAccountList();
        for (Account account : accountList) {
            System.out.println(account);
        }
        return CommonResult.success(accountList);
    }

    @GetMapping("/queryAccountById")
    public CommonResult queryAccountById(Integer id){
        if (accountMapper.selectById(id)==null){
            return CommonResult.failed("查询失败");
        }else {
            return CommonResult.success(accountMapper.selectById(id));
        }
    }

    @PostMapping("/updateAccount")
    public CommonResult updateAccount(Account account){
        if (accountMapper.update(account)){
            return CommonResult.success("修改成功",account);
        }else {
            return CommonResult.failed("修改失败");
        }
    }

    @PostMapping("/addAccount")
    public CommonResult addAccount(Account account){
        if (accountMapper.insert(account)==1){
            return CommonResult.success("添加成功",account);
        }else {
            return CommonResult.failed("添加失败");
        }
    }

    @DeleteMapping("DeleteAccount")
    public CommonResult deleteAccount(Account account){
        if (accountMapper.deleteById(account)==1){
            return CommonResult.success("删除成功");
        }else {
            return CommonResult.failed("删除失败");
        }
    }

}

