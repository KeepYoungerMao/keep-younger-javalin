package com.mao;

import com.mao.config.Path;
import com.mao.service.about.AboutService;
import com.mao.service.classical.BjxService;
import com.mao.service.classical.BookService;
import com.mao.service.classical.BuddhistService;
import com.mao.service.classical.IdiomService;
import com.mao.service.color.ColorService;
import com.mao.service.index.IndexService;
import com.mao.service.ray.MovieService;
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
            config.addStaticFiles("D:\\image", Location.EXTERNAL);
        }).start(8080);

        app.routes(() -> {
            get(Path.INDEX.url(), IndexService::index);
            path(Path.RAY.url(), () -> {
                get(Path.BILI.url(), RayService::bilibili);
                get(Path.TV.url(), RayService::tv);
                path(Path.MOVIE.url(), () -> {
                    get(Path.MOVIE_INDEX.url(), MovieService::movie);
                    get(Path.MOVIE_LIST.url(), MovieService::movie2);
                    get(Path.MOVIE_SRC.url(), MovieService::movieSrc);
                });
            });
            path(Path.ABOUT.url(), () -> {
                get(Path.ABOUT_PAGE.url(), AboutService::about);
                post(Path.FEEDBACK.url(), AboutService::feedback);
            });
            path(Path.COLOR.url(), () -> {
                get(Path.PIC.url(), ColorService::pic);
                get(Path.PIC_LIST.url(), ColorService::pic2);
                get(Path.PIC_SRC.url(), ColorService::picSrc);
            });
            path(Path.CLASSICAL.url(), () -> {
                path(Path.BUDDHIST.url(), () ->{
                    get(Path.BUDDHIST_INDEX.url(), BuddhistService::buddhist);
                    get(Path.BUDDHIST_SRC.url(), BuddhistService::buddhistChapter);
                    get(Path.BUDDHIST_CHAPTER.url(), BuddhistService::chapter);
                });
                path(Path.BJX.url(), () -> {
                    get(Path.BJX_INDEX.url(), BjxService::bjx);
                    get(Path.BJX_LIST.url(), BjxService::bjx2);
                    get(Path.BJX_SRC.url(), BjxService::bjxSrc);
                });
                path(Path.IDIOM.url(), () -> {
                    get(Path.IDIOM_INDEX.url(), IdiomService::idiom);
                    get(Path.IDIOM_LIST.url(), IdiomService::idiom2);
                    get(Path.IDIOM_SRC.url(), IdiomService::idiomSrc);
                });
                path(Path.BOOK.url(), () -> {
                    get(Path.BOOK_INDEX.url(), BookService::book);
                    get(Path.BOOK_LIST.url(), BookService::book2);
                    get(Path.BOOK_CHAPTER.url(), BookService::bookChapter);
                    get(Path.BOOK_SRC.url(), BookService::chapter);
                });
            });
        });

    }

}