package com.du.rems.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author Du425
 * @since 2021-12-02
 */
@ApiModel(value = "Account对象", description = "")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "aid", type = IdType.AUTO)
    private Integer aid;

    private String accounts;


    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String type) {
        this.accounts = type;
    }

    @Override
    public String toString() {
        return "Account{" +
        "aid=" + aid +
        ", type=" + accounts +
        "}";
    }
}
