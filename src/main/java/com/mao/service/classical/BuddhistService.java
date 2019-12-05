package com.mao.service.classical;

import com.mao.config.MybatisConfigure;
import com.mao.entity.classical.buddhist.Buddhist;
import com.mao.entity.classical.buddhist.BuddhistChapter;
import com.mao.entity.classical.buddhist.BuddhistChapterSrc;
import com.mao.entity.classical.buddhist.SimpleBuddhist;
import com.mao.mapper.classical.BuddhistMapper;
import com.mao.util.ParamUtil;
import io.javalin.http.Context;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.mao.util.MapUtil.addMap;

/**
 * @author mao by 13:59 2019/12/2
 */
public class BuddhistService {

    public static void buddhist(Context ctx){
        SqlSession session = MybatisConfigure.getSession();
        BuddhistMapper mapper = session.getMapper(BuddhistMapper.class);
        List<SimpleBuddhist> buddhist = mapper.getBuddhist();
        session.close();
        ctx.render("classical/buddhist/buddhist.html",addMap("buddhist",buddhist));
    }

    public static void buddhistChapter(Context ctx){
        SqlSession session = MybatisConfigure.getSession();
        BuddhistMapper mapper = session.getMapper(BuddhistMapper.class);
        int id = ParamUtil.getInt(ctx.pathParam("id"));
        Buddhist buddhist = mapper.getBuddhistSrc(id);
        List<BuddhistChapter> chapter = mapper.getBuddhistChapter(id);
        session.close();
        ctx.render("classical/buddhist/buddhistSrc.html",addMap("buddhist",buddhist,"chapter",chapter));
    }

    public static void chapter(Context ctx){
        SqlSession session = MybatisConfigure.getSession();
        BuddhistMapper mapper = session.getMapper(BuddhistMapper.class);
        int id = ParamUtil.getInt(ctx.pathParam("id"));
        BuddhistChapterSrc src = mapper.getBuddhistChapterSrc(id);
        session.close();
        ctx.render("classical/buddhist/chapter.html",addMap("chapter",src));
    }

}