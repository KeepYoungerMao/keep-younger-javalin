package com.mao.service.ray;

import com.mao.config.MybatisConfigure;
import com.mao.config.Path;
import com.mao.entity.ray.tv.M3u8;
import com.mao.mapper.ray.TvMapper;
import io.javalin.http.Context;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import static com.mao.util.MapUtil.addMap;

/**
 * @author mao by 14:10 2019/11/26
 */
public class RayService {

    public static void bilibili(Context ctx){
        ctx.render(Path.BILI.web());
    }

    public static void tv(Context ctx){
        SqlSession session = MybatisConfigure.getSession();
        TvMapper mapper = session.getMapper(TvMapper.class);
        List<M3u8> tvs = mapper.getTvs();
        session.close();
        ctx.render(Path.TV.web(),addMap("tv",tvs));
    }

}