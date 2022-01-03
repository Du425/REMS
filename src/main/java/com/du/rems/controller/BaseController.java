package com.du.rems.controller;

import com.du.rems.core.error.BusinessException;
import com.du.rems.core.error.ErrorMsgType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class BaseController {
    protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler(Exception.class)
    public Object handlerException(Exception e){
        ErrorMsgType responseData;

//        if (e instanceof BusinessException){
//
//        }
        return null;
    }
}
