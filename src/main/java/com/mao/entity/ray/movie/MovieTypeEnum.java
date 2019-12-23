package com.mao.entity.ray.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 电影类型分类
 * @author mao by 11:29 2019/12/23
 */
@Getter
@AllArgsConstructor
public enum MovieTypeEnum {
    all(0),             //全部类型
    jq(1),              //剧情片
    dz(2),              //动作片
    xj(3),              //喜剧片
    kb(4),              //恐怖片
    zz(5),              //战争片
    aq(6),              //爱情片
    kh(7),              //科幻片
    jl(8),              //纪录片
    other(9);           //其它

    private int type;
}