package com.du.rems.service;

import com.du.rems.entity.Record;
import com.baomidou.mybatisplus.extension.service.IService;
import com.du.rems.entity.RecordUserVO;

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
    List<RecordUserVO> recordUser(List<RecordUserVO> list);
}
