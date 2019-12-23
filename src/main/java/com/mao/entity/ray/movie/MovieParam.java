package com.mao.entity.ray.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 电影获取参数
 * @author mao by 11:52 2019/12/23
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieParam {
    private String type;        //类型
    private int type_id;        //类型id
    private String place;       //地点
    private int place_id;       //地点id
    private int order;          //排序
    private int page;           //页码
    private int count;          //总数
}