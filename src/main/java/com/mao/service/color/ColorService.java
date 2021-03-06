package com.mao.service.color;

import com.mao.config.MybatisConfigure;
import com.mao.config.Path;
import com.mao.entity.color.*;
import com.mao.mapper.color.PicMapper;
import com.mao.util.ParamUtil;
import io.javalin.http.Context;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.mao.util.MapUtil.addMap;

/**
 * 处理斑斓模块
 * @author mao in 22:29 2019/11/29
 */
public class ColorService {

    public static void pic(Context ctx){
        pics(ctx,new PicParam(1,1,0,0));
    }

    public static void pic2(Context ctx){
        pics(ctx,getParam(ctx));
    }

    private static PicParam getParam(Context ctx){
        int pid = ParamUtil.getInt(ctx.pathParam("pid"),1);
        int id = ParamUtil.getInt(ctx.pathParam("id"),1);
        int page = ParamUtil.getInt(ctx.pathParam("page"));
        page = page <=1 ? 0 : (page -1)*40;
        return new PicParam(pid,id,page,0);
    }

    private static void pics(Context ctx, PicParam picParam){
        SqlSession session = MybatisConfigure.getSession();
        PicMapper mapper = session.getMapper(PicMapper.class);
        List<PicMainClass> mainClass = mapper.getPicMainClass();
        List<PicSubClass> subClass = mapper.getPicSubClass();
        int count = mapper.getPicCount(picParam.getId());
        picParam.setCount(count);
        List<PicClass> picClass = getPicClass(mainClass, subClass);
        List<SimplePic> pics = mapper.getPic(picParam);
        session.close();
        ctx.render(Path.PIC.web(),addMap(ctx,"picClass",picClass,"pics",pics,"picParam",picParam));
    }

    private static List<PicClass> getPicClass(List<PicMainClass> mainClass, List<PicSubClass> subClass){
        List<PicClass> list = new ArrayList<>();
        for (PicMainClass mClass : mainClass) {
            List<PicClass> subs = new ArrayList<>();
            Iterator<PicSubClass> iterator = subClass.iterator();
            while(iterator.hasNext()){
                PicSubClass next = iterator.next();
                if (next.getPcs_p_id() == mClass.getPcm_id()){
                    subs.add(new PicClass(next.getPcs_id(),next.getPcs_name(),null));
                    iterator.remove();
                }
            }
            list.add(new PicClass(mClass.getPcm_id(),mClass.getPcm_name(),subs));
        }
        return list;
    }

    public static void picSrc(Context ctx){
        SqlSession session = MybatisConfigure.getSession();
        PicMapper mapper = session.getMapper(PicMapper.class);
        int id = ParamUtil.getInt(ctx.pathParam("id"));
        Pic pic = mapper.getPicSrc(id);
        session.close();
        ctx.render(Path.PIC_SRC.web(),addMap(ctx,"pic",pic));
    }

}