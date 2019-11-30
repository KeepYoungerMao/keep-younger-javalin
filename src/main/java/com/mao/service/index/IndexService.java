package com.mao.service.index;

import io.javalin.http.Context;

/**
 * @author mao by 14:53 2019/11/26
 */
public class IndexService {

    public static void index(Context ctx){
        ctx.render("index.html");
    }

}