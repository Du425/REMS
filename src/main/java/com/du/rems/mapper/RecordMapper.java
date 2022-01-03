package com.du.rems.mapper;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.du.rems.entity.Record;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Du425
 * @since 2021-12-20
 */
@Mapper
public interface RecordMapper extends BaseMapper<Record> {

//    List<Record> queryRecordByTime(@Param("beginTime")DateTime beginTime, @Param("endTime") DateTime endTime);
    Page<Record> queryRecordByTime(String startTime, String endTime);
}
