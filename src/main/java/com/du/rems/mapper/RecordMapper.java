package com.du.rems.mapper;

import com.du.rems.entity.Record;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Du425
 * @since 2021-12-01
 */
@Mapper
@Repository
public interface RecordMapper extends BaseMapper<Record> {

}
