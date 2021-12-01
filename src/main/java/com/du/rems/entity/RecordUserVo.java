package com.du.rems.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class RecordUserVo implements Serializable {

    private Integer id;

    private String username;

    private Integer rid;

    private String remarks;

}
