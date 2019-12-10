package com.mao.service.classical;

import com.mao.config.MybatisConfigure;
import com.mao.config.Path;
import com.mao.entity.classical.book.*;
import com.mao.mapper.classical.BookMapper;
import com.mao.util.ParamUtil;
import io.javalin.http.Context;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.mao.util.MapUtil.addMap;

/**
 * 古籍
 * @author mao in 21:17 2019/12/5
 */
public class BookService {

    public static void book(Context ctx){
        books(ctx, new BookParam(0,0,0,0));
    }

    public static void book2(Context ctx){
        String[] param = ParamUtil.getParam(ctx.pathParam("filter"));
        int type = ParamUtil.getInt(param[0]);
        int dynasty = ParamUtil.getInt(param[1]);
        int page = ParamUtil.getInt(param[2],1);
        page = page <= 1 ? 0 : (page - 1)*20;
        books(ctx, new BookParam(type,dynasty,page,0));
    }

    private static void books(Context ctx, BookParam bookParam){
        SqlSession session = MybatisConfigure.getSession();
        BookMapper mapper = session.getMapper(BookMapper.class);
        List<SimpleBook> book = mapper.getBooks(bookParam);
        int count = mapper.getBookCount(bookParam);
        session.close();
        bookParam.setTotal(count);
        ctx.render(Path.BOOK_INDEX.web(), addMap("book",book,"bookParam",bookParam));
    }

    public static void bookChapter(Context ctx){
        SqlSession session = MybatisConfigure.getSession();
        BookMapper mapper = session.getMapper(BookMapper.class);
        int id = ParamUtil.getInt(ctx.pathParam("id"));
        Book book = mapper.getBook(id);
        List<BookChapter> chapter = mapper.getBookChapter(id);
        session.close();
        ctx.render(Path.BOOK_CHAPTER.web(), addMap("book",book,"chapter",chapter));
    }

    public static void chapter(Context ctx){
        SqlSession session = MybatisConfigure.getSession();
        BookMapper mapper = session.getMapper(BookMapper.class);
        BookChapterSrc src = mapper.getBookChapterSrc(ParamUtil.getInt(ctx.pathParam("id")));
        session.close();
        ctx.render(Path.BOOK_SRC.web(), addMap("src",src));
    }

}