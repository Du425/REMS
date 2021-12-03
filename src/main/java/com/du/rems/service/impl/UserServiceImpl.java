package com.du.rems.service.impl;

import com.du.rems.entity.User;
import com.du.rems.mapper.UserMapper;
import com.du.rems.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Du425
 * @since 2021-12-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
