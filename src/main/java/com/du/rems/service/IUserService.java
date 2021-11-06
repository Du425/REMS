package com.du.rems.service;

import com.du.rems.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Du425
 * @since 2021-11-06
 */
public interface IUserService extends IService<User> {
    int deleteUserByIdOrUsername(User user);


}
