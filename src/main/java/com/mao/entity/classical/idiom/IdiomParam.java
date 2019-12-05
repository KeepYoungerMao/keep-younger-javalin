package com.mao.entity.classical.idiom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 成语参数
 * @author mao by 10:59 2019/12/5
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdiomParam {
    private String sp;
    private String qp;
    private String name;
    private int page;
    private int total;
}