package com.mao.entity.color;

import lombok.Getter;
import lombok.Setter;

/**
 * 图片
 * @author mao in 22:19 2019/11/29
 */
@Getter
@Setter
public class Pic {

    private int id;             //id
    private int mid;
    private String m_name;      //main class name
    private int sid;
    private String s_name;      //sub class name
    private String name;        //图片名称
    private String image;       //大图片
    private String key;         //关键词

}