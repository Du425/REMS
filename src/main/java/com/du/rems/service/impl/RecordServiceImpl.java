package com.du.rems.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.du.rems.entity.Record;
import com.du.rems.mapper.RecordMapper;
import com.du.rems.service.IRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {
    @Autowired
    private RecordMapper recordMapper;
    @Override
    public int queryRecordById(Record record){
//        Integer id = record.getId();
//        QueryWrapper<Record> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("id",record.getId());
//        Record record1 = recordMapper.selectOne(queryWrapper.select("id"));
//        Record record2 = recordMapper.selectById(id);
//        return 1;
        Integer id = record.getId();
        if (id==null);
        UpdateWrapper<Record> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("id",record.getId());
        int id1 = recordMapper.updateById(getById("id"));
        return id1;
    }

}
