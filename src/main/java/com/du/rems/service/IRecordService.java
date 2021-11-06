package com.du.rems.service;

import com.du.rems.entity.Record;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Du425
 * @since 2021-11-06
 */
public interface IRecordService extends IService<Record> {
    int queryRecordById(Record record);
}
