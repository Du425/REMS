package com.du.rems.core.error;

public class BusinessException extends Exception implements CommonError{

    private CommonError commonError;
    // 直接接受EmBusinessError的传参用于构造业务异常
    public BusinessException(CommonError commonError){
        super();
        this.commonError = commonError;
    }
    // 接受自定义errMsg的方式构造业务异常
    public BusinessException(CommonError commonError, String errorMsg){
        super();
        this.commonError = commonError;
        this.commonError.setErrorMsg(errorMsg);
    }

    @Override
    public int getErrorCode() {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return this.commonError.getErrorMsg();
    }

    @Override
    public CommonError setErrorMsg(String errorMsg) {
        return this.commonError.setErrorMsg(errorMsg);
    }
}
