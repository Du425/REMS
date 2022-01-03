package com.du.rems.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.du.rems.entity.Record;
import com.du.rems.mapper.RecordMapper;
import com.du.rems.mapper.UserMapper;
import com.du.rems.response.CommonResult;
import com.du.rems.service.IRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private IRecordService recordService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryRecordList")
    public CommonResult queryRecordList() {
        QueryWrapper<Record> objectQueryWrapper = new QueryWrapper<>(null);
        List<Record> recordList = recordMapper.selectList(objectQueryWrapper);
        for (Record record : recordList) {
            System.out.println(record);
        }
        return CommonResult.success(recordList);
    }

    @GetMapping("/queryRecordById")
    public CommonResult queryRecordById(Integer id) {

        return CommonResult.success(recordMapper.selectById(id));
    }

    @PostMapping("/addRecord")
    public CommonResult addRecord(@Validated @RequestBody Record record) {

//        QueryWrapper<Record> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("user_id",record.getUserId());
//        Record record1 = recordMapper.selectOne(queryWrapper);
//
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("id", record.getUserId());
//        User user = userMapper.selectOne(queryWrapper);
        if (recordMapper.insert(record) == 1) {
//            user.setMoneySpend(user.getMoneySpend() + record.getSpendMoney());
            return CommonResult.success("添加成功", record);
        } else {
            return CommonResult.failed("添加失败");
        }
    }

    @DeleteMapping("/deleteRecord")
    public CommonResult deleteUser(Integer id){
        if (recordMapper.deleteById(id)==1){
            return CommonResult.success("删除成功");
        }else {
            return CommonResult.failed("删除失败");
        }
    }
    @PostMapping("/updateRecordById")
    public CommonResult updateRecordById(Record record){
        if (recordMapper.updateById(record)==1){
            return CommonResult.success("更新成功",record);
        }else {
            return CommonResult.failed("更新失败");
        }
    }

    @GetMapping("/queryRecordByTime")
    public CommonResult queryRecordByTime(@PathVariable String startTime, String endTime){
//        PageInfo<Record> pageInfo = new PageInfo<>(recordMapper.queryRecordByTime(startTime, endTime));
//        return CommonResult.success("查询成功",pageInfo);

        return CommonResult.success(recordMapper.queryRecordByTime(startTime, endTime));

    }



}
