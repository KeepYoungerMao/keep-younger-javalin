package com.mao.entity.color;

import lombok.*;

/**
 * 图片参数
 * @author mao in 19:52 2019/11/30
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PicParam {
    private int pid;        //main class id
    private int id;         //sub class id
    private int page;       //current page
    private int count;      //total count
}