package com.du.rems.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
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
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String nick;

    private String username;

    private String password;

    private String telephone;

    private String email;

    private BigDecimal sumMoney;

    private BigDecimal moneySpend;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(BigDecimal sumMoney) {
        this.sumMoney = sumMoney;
    }

    public BigDecimal getMoneySpend() {
        return moneySpend;
    }

    public void setMoneySpend(BigDecimal moneySpend) {
        this.moneySpend = moneySpend;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", nick=" + nick +
        ", username=" + username +
        ", password=" + password +
        ", telephone=" + telephone +
        ", email=" + email +
        ", sumMoney=" + sumMoney +
        ", moneySpend=" + moneySpend +
        "}";
    }
}
