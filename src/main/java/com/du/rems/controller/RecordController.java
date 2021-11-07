package com.du.rems.controller;


import com.du.rems.entity.Record;
import com.du.rems.mapper.RecordMapper;
import com.du.rems.response.CommonResult;
import com.du.rems.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Controller
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private IRecordService recordService;

    @GetMapping("/queryRecordList")
    public CommonResult queryRecordList(){
        List<Record> recordList = recordMapper.queryRecordList();
        for (Record record: recordList){
            System.out.println(record);
        }
        return CommonResult.success(recordList);
    }

    @GetMapping("/queryRecordById")
    public CommonResult queryRecordById(Integer id) {

        return CommonResult.success(recordMapper.selectById(id)) ;
    }

    @PostMapping("/addRecord")
    public CommonResult addRecord(Record record){
        if (recordMapper.insert(record)==1){
            return CommonResult.success("添加成功",record) ;
        }else {
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


}

