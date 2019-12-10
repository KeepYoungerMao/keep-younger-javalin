package com.mao.service.classical;

import com.mao.config.MybatisConfigure;
import com.mao.config.Path;
import com.mao.entity.classical.idiom.Idiom;
import com.mao.entity.classical.idiom.IdiomParam;
import com.mao.entity.classical.idiom.SimpleIdiom;
import com.mao.mapper.classical.IdiomMapper;
import com.mao.util.ParamUtil;
import com.mao.util.SU;
import io.javalin.http.Context;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.mao.util.MapUtil.addMap;

/**
 * 成语
 * @author mao by 10:31 2019/12/5
 */
public class IdiomService {

    public static void idiom(Context ctx){
        idioms(ctx,new IdiomParam("a",null,null,0,0));
    }

    public static void idiom2(Context ctx){
        String[] param = ParamUtil.getParam(ctx.pathParam("filter"));
        String sp = null, qp = null, name = null;
        int page = -1;
        if (param.length >= 2){
            sp = SU.isEmpty(param[0]) ? null : param[0].toLowerCase();
            if (SU.isNotEmpty(param[1]))
                if (SU.isNumber(param[1]))
                    page = Integer.parseInt(param[1]);
                else if (SU.isZM(param[1]))
                    qp = param[1].toUpperCase();
                else name = param[1];
            else page = 1;
        }
        page = (page != -1 && page <= 1) ? 0 : (page - 1)*40;
        idioms(ctx, new IdiomParam(sp,qp,name,page,0));
    }

    private static void idioms(Context ctx, IdiomParam param){
        SqlSession session = MybatisConfigure.getSession();
        IdiomMapper mapper = session.getMapper(IdiomMapper.class);
        List<SimpleIdiom> idioms = mapper.getIdiom(param);
        if (param.getPage() >= 0){
            int count = mapper.getIdiomCount(param.getSp());
            param.setTotal(count);
        }
        session.close();
        ctx.render(Path.IDIOM_INDEX.web(), addMap("idioms",idioms,"idiomParam",param));
    }

    public static void idiomSrc(Context ctx){
        SqlSession session = MybatisConfigure.getSession();
        IdiomMapper mapper = session.getMapper(IdiomMapper.class);
        int id = ParamUtil.getInt(ctx.pathParam("id"));
        Idiom idiom = mapper.getIdiomSrc(id);
        session.close();
        ctx.render(Path.IDIOM_SRC.web(), addMap("idiom",idiom));
    }

}