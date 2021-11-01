package com.du.rems.controller;


import com.du.rems.entity.Record;
import com.du.rems.entity.User;
import com.du.rems.mapper.RecordMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Du425
 * @since 2021-10-31
 */
@Controller
@RequestMapping("/record")
@Api(value = "/record",tags = "单笔记录")
public class RecordController {
    @Autowired
    private RecordMapper recordMapper;

    @GetMapping("/queryRecordList")
    @ApiOperation(value = "查询",notes = "每条记录查询")
    public List<Record> queryRecordList(){
       return recordMapper.selectList(null);

    }
    @GetMapping("/addRecord")
    public String addRecord(@RequestBody Record record) {
        if (recordMapper.insert(record) == 1) {
            return "add success";
        } else {
            return "fail";
        }
    }

    @GetMapping("deleteRecordr")
    public String deleteRecord(@RequestParam int id) {
        if (recordMapper.deleteById(id) == 1) {
            return "delete success";
        }else{
            return "delete fail";
        }
    }
    @GetMapping("updateRecord")
    public String updateRecord(@RequestBody Record record) {
        if (recordMapper.updateById(record) == 1) {
            return "update success";
        } else {
            return "update fail";
        }
    }
    @GetMapping("queryRecordById")
    public Record queryRecordById(@RequestParam int id){
        return recordMapper.selectById(id);
    }


}

