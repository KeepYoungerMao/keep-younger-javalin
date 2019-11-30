package com.mao.entity.color;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 图片分类，用于前端展现
 * @author mao in 22:26 2019/11/29
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PicClass {

    private int id;                 //id
    private String name;            //name
    private List<PicClass> child;   //child

}