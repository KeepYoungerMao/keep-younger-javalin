package com.mao.entity.classical.book;

import lombok.Getter;
import lombok.Setter;

/**
 * 古籍
 * @author mao by 14:07 2019/12/5
 */
@Getter
@Setter
public class Book {
    private int id;
    private String name;
    private String auth;
    private String image;
    private String intro;
    private String type;
    private int type_id;
    private String dynasty;
    private int dynasty_id;
}