package com.du.rems.controller;
import com.du.rems.entity.Category;
import com.du.rems.entity.Record;
import com.du.rems.mapper.CategoryMapper;
import com.du.rems.response.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping("/queryCategoryList")
    public CommonResult queryCategoryList(){
        List<Category> categoryList = categoryMapper.selectList(null);
        for (Category category : categoryList) {
            System.out.println(category);
        }
        return CommonResult.success(categoryList);
    }

    @GetMapping("/queryCategoryById")
    public CommonResult queryCategoryById(Integer id){
        return CommonResult.success(categoryMapper.selectById(id));
    }

    @PostMapping("/addCategory")
    public CommonResult addCategory(Category category){
        if (categoryMapper.insert(category)==1){
            return CommonResult.success("添加成功",category);
        }else {
            return CommonResult.failed("添加失败");
        }
    }

    @PostMapping("/updateCategoryById")
    public CommonResult updateCategoryById(Category category){
        if (categoryMapper.updateById(category)==1){
            return CommonResult.success("修改成功",category);
        }else {
            return CommonResult.failed("修改失败");
        }
    }

    @DeleteMapping("/deleteCategoryById")
    public CommonResult deleteCategoryById(Integer id){
        if (categoryMapper.deleteById(id)==1){
            return CommonResult.success("删除成功");
        }else {
            return CommonResult.failed("删除失败");
        }
    }

}
