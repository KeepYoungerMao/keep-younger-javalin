package com.mao.service.about;

import com.mao.config.Path;
import com.mao.mapper.about.FeedbackMapper;
import com.mao.config.MybatisConfigure;
import com.mao.entity.about.FeedBack;
import com.mao.service.BaseService;
import com.mao.util.SU;
import io.javalin.http.Context;
import org.apache.ibatis.session.SqlSession;

/**
 * 处理关于模块
 * @author mao by 14:44 2019/11/26
 */
public class AboutService extends BaseService {

    public static void about(Context ctx){
        String page = ctx.pathParam("page");
        ctx.render(Path.ABOUT_PAGE.web().replaceAll("[$]",page));
    }

    public static void feedback(Context ctx){
        FeedBack feedBack = ctx.bodyAsClass(FeedBack.class);
        if (SU.isEmpty(feedBack.getTitle())){
            ctx.json(bad("标题是空的"));
            return;
        }
        if (feedBack.getTitle().length() > 20){
            ctx.json(bad("标题超过了20个字"));
            return;
        }
        if (SU.isEmpty(feedBack.getAdvise())){
            ctx.json(bad("建议是空的"));
            return;
        }
        if (feedBack.getAdvise().length() > 200){
            ctx.json(bad("建议超过了200个字"));
            return;
        }
        if (!SU.isEmail(feedBack.getEmail())){
            ctx.json(bad("邮箱是无效的"));
            return;
        }
        if (SU.isNotEmpty(feedBack.getName()) && feedBack.getName().length() > 20){
            ctx.json(bad("名字太长了"));
            return;
        }
        SqlSession session = MybatisConfigure.getSession();
        FeedbackMapper mapper = session.getMapper(FeedbackMapper.class);
        mapper.saveFeedBack(feedBack);
        session.commit();
        session.close();
        ctx.json(ok("保存成功"));
    }

}