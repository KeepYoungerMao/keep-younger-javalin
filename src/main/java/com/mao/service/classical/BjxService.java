package com.mao.service.classical;

import com.mao.config.MybatisConfigure;
import com.mao.entity.classical.bjx.Bjx;
import com.mao.entity.classical.bjx.BjxParam;
import com.mao.entity.classical.bjx.BjxSrc;
import com.mao.mapper.classical.BjxMapper;
import com.mao.util.ParamUtil;
import com.mao.util.SU;
import io.javalin.http.Context;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.mao.util.MapUtil.addMap;

/**
 * 百家姓
 * @author mao in 22:57 2019/12/2
 */
public class BjxService {

    public static void bjx(Context ctx){
        bjxS(ctx,new BjxParam("A",null));
    }

    public static void bjx2(Context ctx){
        String[] param = ParamUtil.getParam(ctx.pathParam("filter"));
        String py = null, name = null;
        if (param.length >= 2){
            py = SU.isEmpty(param[0]) ? null : param[0].toUpperCase();
            name = SU.isEmpty(param[1]) ? null : param[1];
        }
        bjxS(ctx,new BjxParam(py,name));
    }

    private static void bjxS(Context ctx, BjxParam param){
        SqlSession session = MybatisConfigure.getSession();
        BjxMapper mapper = session.getMapper(BjxMapper.class);
        List<Bjx> bjx = mapper.getBjx(param);
        session.close();
        ctx.render("classical/bjx/bjx.html",addMap("bjx",bjx,"bjxParam",param));
    }

    public static void bjxSrc(Context ctx){
        SqlSession session = MybatisConfigure.getSession();
        BjxMapper mapper = session.getMapper(BjxMapper.class);
        int id = ParamUtil.getInt(ctx.pathParam("id"));
        BjxSrc bjx = mapper.getBjxSrc(id);
        ctx.render("/classical/bjx/bjxSrc.html",addMap("bjx",bjx));
    }

}