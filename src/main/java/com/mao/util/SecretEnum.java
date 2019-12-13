package com.mao.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 加密类型。有密钥的加密分类
 * @author mao by 18:25 2019/8/19
 */
@Getter
@AllArgsConstructor
public enum SecretEnum {

    AES("AES",128),
    DES("DES",56);

    private String type;
    private int strong;

}