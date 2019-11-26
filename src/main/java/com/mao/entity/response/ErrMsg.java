package com.mao.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 错误信息体
 * @author mao by 16:57 2019/10/22
 */
@Getter
@Setter
@AllArgsConstructor
public class ErrMsg {
    private String err_msg;
}