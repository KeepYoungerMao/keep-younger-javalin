package com.mao.entity.classical.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 古籍 参数
 * @author mao in 21:20 2019/12/5
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookParam {
    private int type;       //type id
    private int dynasty;    //dynasty id
    private int page;       //current page index
    private int total;      //total
}