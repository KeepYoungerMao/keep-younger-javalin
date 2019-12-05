package com.mao.entity.classical.book;

import lombok.Getter;
import lombok.Setter;

/**
 * 古籍章节详情
 * @author mao in 22:10 2019/12/5
 */
@Getter
@Setter
public class BookChapterSrc {
    private int id;             //古籍id
    private String name;        //古籍名称
    private String auth;        //作者
    private String image;       //图片
    private String intro;       //介绍
    private String type;        //类型
    private String dynasty;     //朝代
    private String chapter;     //章节
    private String src;         //详情
}