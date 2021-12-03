package com.du.rems.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@ApiModel(value = "Record对象", description = "")
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "rid", type = IdType.AUTO)
    private Integer rid;

    @TableField(fill = FieldFill.INSERT)
    private BigDecimal spendMoney;

    private Integer userId;

    private Integer categoryId;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime time;

    @TableLogic
    private String remarks;

    private Integer accountId;


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public BigDecimal getSpendMoney() {
        return spendMoney;
    }

    public void setSpendMoney(BigDecimal spendMoney) {
        this.spendMoney = spendMoney;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Record{" +
        "rid=" + rid +
        ", spendMoney=" + spendMoney +
        ", userId=" + userId +
        ", categoryId=" + categoryId +
        ", time=" + time +
        ", remarks=" + remarks +
        ", accountId=" + accountId +
        "}";
    }
}
