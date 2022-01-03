package com.du.rems.service;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.du.rems.entity.Record;
import com.baomidou.mybatisplus.extension.service.IService;
import com.du.rems.entity.RecordUserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Du425
 * @since 2021-12-02
 */
public interface IRecordService extends IService<Record> {
//    List<RecordUserVO> recordUser(List<RecordUserVO> list);

    //List<Record> queryRecordByTime(@Param("startDate")DateTime StartDate, @Param("endDate") DateTime endDate);
//    Page<Record> queryRecordByTime(String startTime, String endTime);

}
