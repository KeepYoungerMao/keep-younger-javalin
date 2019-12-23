package com.mao.entity.ray.movie;

import lombok.Getter;
import lombok.Setter;

/**
 * 电影列表包装类
 * @author mao by 11:43 2019/12/23
 */
@Getter
@Setter
public class SimpleMovie {
    private int id;             //id
    private String name;        //名称
    private String image;       //封面
    private String type;        //类型
    private int time;           //上映时间
    private String place;       //上映地点
    private String weight;      //画质/清晰度
}