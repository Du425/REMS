package com.du.rems.shiro;

import lombok.Data;

import java.io.Serializable;

//封装，序列化
@Data
public class AccountProfile implements Serializable {
    private Long id;

    private String username;

    private String email;
}
