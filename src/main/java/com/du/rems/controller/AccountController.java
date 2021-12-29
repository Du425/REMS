package com.du.rems.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.du.rems.entity.Account;
import com.du.rems.mapper.AccountMapper;
import com.du.rems.response.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Du425
 * @since 2021-11-06
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountMapper accountMapper;

    @GetMapping("/queryAccountList")
    public CommonResult queryAccountList() {
        QueryWrapper<Account> objectQueryWrapper = new QueryWrapper<>(null);
        List<Account> accountList = accountMapper.selectList(objectQueryWrapper);
        for (Account account : accountList) {
            System.out.println(account);
        }
        return CommonResult.success(accountList);
    }

    @GetMapping("/queryAccountById")
    public CommonResult queryAccountById(Integer id) {
        if (accountMapper.selectById(id) == null) {
            return CommonResult.failed("查询失败");
        } else {
            return CommonResult.success(accountMapper.selectById(id));
        }
    }

    @PostMapping("/updateAccount")
    public CommonResult updateAccount(Account account) {
        int update = accountMapper.updateById(account);
        if (update == 1) {
            return CommonResult.success("修改成功", account);
        } else {
            return CommonResult.failed("修改失败");
        }
    }

    @PostMapping("/addAccount")
    public CommonResult addAccount(Account account) {
        if (accountMapper.insert(account) == 1) {
            return CommonResult.success("添加成功", account);
        } else {
            return CommonResult.failed("添加失败");
        }
    }

    @DeleteMapping("DeleteAccount")
    public CommonResult deleteAccount(Account account) {
        if (accountMapper.deleteById(account) == 1) {
            return CommonResult.success("删除成功");
        } else {
            return CommonResult.failed("删除失败");
        }
    }
}
