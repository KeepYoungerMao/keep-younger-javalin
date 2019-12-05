package com.mao.entity.classical.idiom;

import lombok.Getter;
import lombok.Setter;

/**
 * 成语
 * @author mao by 10:21 2019/12/5
 */
@Getter
@Setter
public class Idiom {
    private int tt_id;                          //id
    private String tt_name;                     //成语名称
    private String tt_full_pin;                 //全拼
    private String tt_traditional_name;         //繁体
    private String tt_first_pin;                //首拼
    private String tt_simple_pin;               //简拼
    private String tt_phonetic_notation;        //注音
    private String tt_standard_notation;        //正音
    private String tt_explain;                  //解释
    private String tt_source;                   //出处
    private String tt_analysis;                 //辨析
    private String tt_story;                    //成语故事
    private String tt_man_days;                 //使用程度：常用、一般、生僻
    private String tt_emotion;                  //感情色彩：中性、褒义、贬义
    private String tt_usage;                    //用法
    private String tt_discriminate;             //辨形
    private String tt_years;                    //年代
    private String tt_synonym;                  //近义词
    private String tt_antonym;                  //反义词
    private String tt_example;                  //举例
    private String tt_riddle;                   //谜语
    private String tt_xie_hou_yu;               //歇后语
    private String tt_english;                  //英语
    private String tt_japanese;                 //日语
    private String tt_russian;                  //俄语
    private String tt_ot_translate;             //其他翻译
}