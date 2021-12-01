package com.du.rems.util;

import com.du.rems.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

public class ShiroUtil {

    public static AccountProfile getProfile(){
//
//        JSONObject jsonObject= JSONUtil.parseObj(SecurityUtils.getSubject().getPrincipal());
//
//        return JSONUtil.toBean(jsonObject,AccountProfile.class) ;
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}
