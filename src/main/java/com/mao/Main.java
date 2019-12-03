package com.mao;

import com.mao.service.classical.BjxService;
import com.mao.service.about.AboutService;
import com.mao.service.classical.BuddhistService;
import com.mao.service.color.ColorService;
import com.mao.service.index.IndexService;
import com.mao.service.ray.RayService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.plugin.rendering.template.JavalinThymeleaf;

import static com.mao.config.ThymeleafConfig.thymeleafConfig;
import static io.javalin.apibuilder.ApiBuilder.*;

/**
 * javalin主方法
 * 关于 JavalinThymeleaf.configure()
 * 含义：表示模板引擎thymeleaf的配置
 *      javalin默认启动便配置可支持的全部引擎。但使用中发现thymeleaf的“th:replace”公共模块替换功能不成功
 *      原因是thymeleaf找不到公共模块的路径。手动配置后成功替换。
 * 关于 config.addStaticFiles()
 * 含义：表示静态资源的配置。
 *      可以配置项目内部静态资源（内部资源必须配置）（默认：Location.CLASSPATH）：
 *          config.addStaticFiles("/public");
 *          如public下的a.jpg可以被访问：localhost:8080/a.jpg
 *      可以配置项目外部资源（项目之外，本机其他文件夹）：
 *          config.addStaticFiles("D:\\image", Location.EXTERNAL);
 *          如image文件夹下的animal下的dog.jpg可以被访问：localhost:8080/animal/dog.jpg
 *      如：public下有文件x.txt，image文件夹下有x.txt，访问localhost:8080/x.txt优先内部资源。
 * @author mao by 13:55 2019/11/26
 */
public class Main {

    public static void main(String[] args) {

        JavalinThymeleaf.configure(thymeleafConfig());

        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/public");
            config.addStaticFiles("F:\\self\\image", Location.EXTERNAL);
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
            path("color", () -> {
                get("pic", ColorService::pic);
                get("pic/:pid/:id/:page", ColorService::pic2);
                get("pic/src/:id",ColorService::picSrc);
            });
            path("classical", () -> {
                get("buddhist", BuddhistService::buddhist);
                get("buddhist/:id", BuddhistService::buddhistChapter);
                get("buddhist/chapter/:id", BuddhistService::chapter);
                get("bjx", BjxService::bjx);
                get("bjx/:py", BjxService::bjx2);
                get("bjx/:py/:name", BjxService::bjx3);
                get("bjxSrc/:id", BjxService::bjxSrc);
            });
        });

    }

}