package com.du.rems.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.du.rems.entity.Record;
import com.du.rems.entity.RecordUserVO;
import com.du.rems.entity.User;
import com.du.rems.mapper.RecordMapper;
import com.du.rems.service.IRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.du.rems.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Du425
 * @since 2021-12-02
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {

//    @Autowired
//    IUserService iUserService;
//
//    @Override
//    public List<RecordUserVO> recordUser(List<RecordUserVO> list) {
//        if (list == null || list.size() < 1){
//            return null;
//        }
//        final List<RecordUserVO> recordUserVOS = list.stream().map(m ->{
//            final RecordUserVO recordUserVO = new RecordUserVO();
//            final User id = iUserService.getById(1L);
//            return recordUserVO;
//
//        }).collect(Collectors.toList());
//        return recordUserVOS;
//    }
//
//    @Override
//    public Page<Record> queryRecordByTime(String startTime, String endTime) {
//        return null;
//    }
//
////    @Override
////    public List<Record> queryRecordByTime(DateTime StartDate, DateTime endDate) {
////        return null;
////    }
}
