package com.du.rems.mapper;

import com.du.rems.entity.Category;
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
 * @since 2021-11-06
 */
@Mapper
@Repository
public interface CategoryMapper extends BaseMapper<Category> {

    List<Category> queryCategoryList();

    int updateById();
}
