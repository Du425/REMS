package com.du.rems.mapper;

import com.du.rems.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Du425
 * @since 2021-10-31
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {



}
