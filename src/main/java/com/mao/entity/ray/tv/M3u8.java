package com.mao.entity.ray.tv;

import lombok.Getter;
import lombok.Setter;

/**
 * m3u8电视直播地址
 * @author mao by 10:51 2019/11/9
 */
@Getter
@Setter
public class M3u8 {
    private int id;
    private String name;
    private String url;
    private int type;
    private String kind;
}