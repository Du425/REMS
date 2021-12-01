package com.du.rems.service.impl;

import com.du.rems.entity.Account;
import com.du.rems.mapper.AccountMapper;
import com.du.rems.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Du425
 * @since 2021-12-01
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
