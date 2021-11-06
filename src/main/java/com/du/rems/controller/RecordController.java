package com.du.rems.controller;


import com.du.rems.entity.Record;
import com.du.rems.mapper.RecordMapper;
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
    public List<Record> queryRecordList(){
        List<Record> recordList = recordMapper.queryRecordList();
        for (Record record: recordList){
            System.out.println(record);
        }
        return recordList;
    }

    @GetMapping("/queryRecordById")
    public String queryRecordById(Record record){
        if (){
            System.out.println(record);
        }
    }

    @PostMapping("/addRecord")
    public String addRecord(Record record){
        if (recordMapper.insert(record)==1){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    @DeleteMapping("/deleteRecord")
    public String deleteUser(Record record){
        if (recordService.queryRecordById(record)==1){
            return "查询成功";
        }else {
            return "查询失败";
        }
    }


}

