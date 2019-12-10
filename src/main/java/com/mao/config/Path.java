package com.mao.config;

/**
 * 页面路径配置
 * @author mao by 14:54 2019/12/10
 */
public enum Path {

    INDEX("","index.html"),                                                 //首页
    RAY("ray",null),                                                        //射线 -- 分类
    BILI("bilibili","ray/bilibili.html"),                                   //B站
    TV("tv","ray/tv.html"),                                                 //电视
    ABOUT("about",null),                                                    //关于 -- 分类
    ABOUT_PAGE(":page","about/$.html"),                                     //关于
    FEEDBACK("feedback",null),                                              //反馈 -- 数据
    COLOR("color",null),                                                    //斑斓 -- 分类
    PIC("pic","color/pic.html"),                                            //图片
    PIC_LIST("pic/:pid/:id/:page","color/pic.html"),                        //图片
    PIC_SRC("pic/src/:id","color/picSrc.html"),                             //图片详情
    CLASSICAL("classical",null),                                            //古韵 -- 分类
    BUDDHIST("buddhist",null),                                              //佛经 -- 分类
    BUDDHIST_INDEX("","classical/buddhist/buddhist.html"),                  //佛经
    BUDDHIST_SRC(":id","classical/buddhist/buddhistSrc.html"),              //佛经章节
    BUDDHIST_CHAPTER("chapter/:id","classical/buddhist/chapter.html"),      //佛经章节详情
    BJX("bjx",null),                                                        //百家姓 -- 分类
    BJX_INDEX("","classical/bjx/bjx.html"),                                 //百家姓
    BJX_LIST(":filter","classical/bjx/bjx.html"),                           //百家姓
    BJX_SRC("src/:id","classical/bjx/bjxSrc.html"),                         //百家姓详情
    IDIOM("idiom",null),                                                    //成语 -- 分类
    IDIOM_INDEX("","classical/idiom/idiom.html"),                           //成语
    IDIOM_LIST(":filter","classical/idiom/idiom.html"),                     //成语
    IDIOM_SRC("src/:id","classical/idiom/idiomSrc.html"),                   //成语详情
    BOOK("book",null),                                                      //古籍 -- 分类
    BOOK_INDEX("","classical/book/book.html"),                              //古籍
    BOOK_LIST(":filter","classical/book/book.html"),                        //古籍
    BOOK_CHAPTER("chapter/:id","classical/book/chapter.html"),              //古籍章节
    BOOK_SRC("chapter/src/:id","classical/book/src.html");                  //古籍章节详情


    private String url;     //链接
    private String web;     //地址

    Path(String url, String web) {
        this.url = url;
        this.web = web;
    }

    public String url(){
        return this.url;
    }

    public String web(){
        return this.web;
    }

}