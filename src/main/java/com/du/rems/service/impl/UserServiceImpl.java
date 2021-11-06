package com.du.rems.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.du.rems.entity.User;
import com.du.rems.mapper.UserMapper;
import com.du.rems.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Du425
 * @since 2021-11-06
 */
@Service

public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int deleteUserByIdOrUsername(User user) {
        Integer id = user.getId();
        if (id == null){
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username", user.getUsername());
//        userMapper.delete(queryWrapper);
            User user1 = userMapper.selectOne(queryWrapper.select("id"));
            id = user1.getId();
        }
        int i = userMapper.deleteById(id);
        return i;
    }
}
