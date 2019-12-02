package com.mao.mapper.classical;

import io.javalin.http.Context;

/**
 * 百家姓
 * @author mao in 22:57 2019/12/2
 */
public class BjxService {

    public static void bjx(Context ctx){
        ctx.render("classical/bjx/bjx.html");
    }

}