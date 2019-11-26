package com.mao;

import com.mao.service.about.AboutService;
import com.mao.index.IndexService;
import com.mao.service.ray.RayService;
import io.javalin.Javalin;
import io.javalin.plugin.rendering.template.JavalinThymeleaf;

import static com.mao.config.ThymeleafConfig.thymeleafConfig;
import static io.javalin.apibuilder.ApiBuilder.*;

/**
 * @author mao by 13:55 2019/11/26
 */
public class Main {

    public static void main(String[] args) {

        JavalinThymeleaf.configure(thymeleafConfig());

        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/public");
        }).start(8080);

        app.routes(() -> {
            get("", IndexService::index);
            path("ray", () -> {
                get("bilibili", RayService::bilibili);
                get("tv", RayService::tv);
            });
            path("about", () -> {
                get(":page", AboutService::about);
                post("feedback", AboutService::feedback);
            });
        });

    }

}