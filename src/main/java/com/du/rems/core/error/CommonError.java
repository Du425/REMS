package com.du.rems.core.error;

public interface CommonError {

    int getErrorCode();
    String getErrorMsg();

    CommonError setErrorMsg(String errorMsg);

}
