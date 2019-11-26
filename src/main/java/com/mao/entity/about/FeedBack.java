package com.mao.entity.about;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 反馈
 * @author mao by 20:19 2019/11/20
 */
@Getter
@Setter
@ToString
public class FeedBack {

    private int id;             //id
    private String title;       //标题
    private String advise;      //建议
    private String name;        //名字
    private String email;       //邮箱

}