package com.mao.entity.ray.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 电影上映地点类型
 * @author mao by 10:46 2019/12/23
 */
@Getter
@AllArgsConstructor
public enum MoviePlaceEnum {
    all(0),                     //全部类型
    //china(1),                 //中国（已规划到land）
    land(2),                    //大陆
    taiwan(3),                  //台湾
    hongkong(4),                //香港
    america(5),                 //美国
    korea(6),                   //韩国
    japan(7),                   //日本
    france(8),                  //法国
    germany(9),                 //德国
    england(10),                //英国
    russia(11),                 //俄罗斯
    canada(12),                 //加拿大
    india(13),                  //印度
    singapore(14),              //新加坡
    thailand(15),               //泰国
    australia(16),              //澳大利亚
    netherlands(17),            //荷兰
    spain(18),                  //西班牙
    malaysia(19),               //马来西亚
    other(20);                  //其它

    private int type;
}