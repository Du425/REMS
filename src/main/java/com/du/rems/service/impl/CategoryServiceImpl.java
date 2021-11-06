package com.du.rems.service.impl;

import com.du.rems.entity.Category;
import com.du.rems.mapper.CategoryMapper;
import com.du.rems.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Du425
 * @since 2021-11-06
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
