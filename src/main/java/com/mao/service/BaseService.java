package com.mao.service;

import com.mao.entity.response.ErrMsg;
import com.mao.entity.response.ResponseData;
import com.mao.entity.response.ResponseEnum;

/**
 * @author mao by 16:57 2019/11/26
 */
public class BaseService {

    protected static  <T> ResponseData ok(T data){
        return o(ResponseEnum.SUCCESS,data);
    }

    protected static ResponseData bad(String msg){
        return o(ResponseEnum.BAD_REQUEST,new ErrMsg(msg));
    }

    public static ResponseData error(String msg){
        return o(ResponseEnum.ERROR,new ErrMsg(msg));
    }

    private static  <T> ResponseData o(ResponseEnum code,T data){
        return new ResponseData<>(code.getType(),data);
    }

}