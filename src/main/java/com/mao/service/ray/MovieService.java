package com.mao.service.ray;

import com.mao.config.MybatisConfigure;
import com.mao.config.Path;
import com.mao.entity.ray.movie.*;
import com.mao.mapper.ray.MovieMapper;
import com.mao.util.ParamUtil;
import io.javalin.http.Context;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.mao.util.MapUtil.addMap;

/**
 * 关于数据的改动：
 * //place
 * UPDATE tt_movie_m3u8 SET `place` = SUBSTRING_INDEX(`time`,'/',-1);
 * UPDATE tt_movie_m3u8 SET `place` = '其它' WHERE `place` IS NULL ;
 * //time
 * UPDATE tt_movie_m3u8 SET `time` = SUBSTRING_INDEX(`time`,'/',1);
 * UPDATE tt_movie_m3u8 SET `time` = '1994' WHERE `time` = '94';
 * UPDATE tt_movie_m3u8 SET `time` = '2019' WHERE `time` = '219';
 * UPDATE tt_movie_m3u8 SET `time` = NULL WHERE `time` = '未知';
 * //修改至BIGINT
 * //添加type_id参数，place_id参数
 * //place_id
 *   UPDATE tt_movie_m3u8 SET `place_id` = 1 WHERE `place` = '中国';
     UPDATE tt_movie_m3u8 SET `place_id` = 2 WHERE `place` = '大陆';
     UPDATE tt_movie_m3u8 SET `place_id` = 3 WHERE `place` = '台湾';
     UPDATE tt_movie_m3u8 SET `place_id` = 4 WHERE `place` = '香港';
     UPDATE tt_movie_m3u8 SET `place_id` = 5 WHERE `place` = '美国';
     UPDATE tt_movie_m3u8 SET `place_id` = 6 WHERE `place` = '韩国';
     UPDATE tt_movie_m3u8 SET `place_id` = 7 WHERE `place` = '日本';
     UPDATE tt_movie_m3u8 SET `place_id` = 8 WHERE `place` = '法国';
     UPDATE tt_movie_m3u8 SET `place_id` = 9 WHERE `place` = '德国';
     UPDATE tt_movie_m3u8 SET `place_id` = 10 WHERE `place` = '英国';
     UPDATE tt_movie_m3u8 SET `place_id` = 11 WHERE `place` = '俄罗斯';
     UPDATE tt_movie_m3u8 SET `place_id` = 12 WHERE `place` = '加拿大';
     UPDATE tt_movie_m3u8 SET `place_id` = 13 WHERE `place` = '印度';
     UPDATE tt_movie_m3u8 SET `place_id` = 14 WHERE `place` = '新加坡';
     UPDATE tt_movie_m3u8 SET `place_id` = 15 WHERE `place` = '泰国';
     UPDATE tt_movie_m3u8 SET `place_id` = 16 WHERE `place` = '澳大利亚';
     UPDATE tt_movie_m3u8 SET `place_id` = 17 WHERE `place` = '荷兰';
     UPDATE tt_movie_m3u8 SET `place_id` = 18 WHERE `place` = '西班牙';
     UPDATE tt_movie_m3u8 SET `place_id` = 19 WHERE `place` = '马来西亚';
     UPDATE tt_movie_m3u8 SET `place_id` = 20 WHERE `place` = '其它';
 * //中国的归大陆
 * UPDATE tt_movie_m3u8 SET place_id = 2 WHERE place_id = 1
 * //type_id
 *   UPDATE tt_movie_m3u8 SET type_id = 1 WHERE `type` = '剧情片';
     UPDATE tt_movie_m3u8 SET type_id = 2 WHERE `type` = '动作片';
     UPDATE tt_movie_m3u8 SET type_id = 3 WHERE `type` = '喜剧片';
     UPDATE tt_movie_m3u8 SET type_id = 4 WHERE `type` = '恐怖片';
     UPDATE tt_movie_m3u8 SET type_id = 5 WHERE `type` = '战争片';
     UPDATE tt_movie_m3u8 SET type_id = 6 WHERE `type` = '爱情片';
     UPDATE tt_movie_m3u8 SET type_id = 7 WHERE `type` = '科幻片';
     UPDATE tt_movie_m3u8 SET type_id = 8 WHERE `type` = '纪录片';
     UPDATE tt_movie_m3u8 SET type_id = 9 WHERE `type` = '电影';
 * //添加count参数
 * @author mao by 10:36 2019/12/23
 */
public class MovieService {

    private static final int RECOMMEND_ORDER = 1;
    private static final int NEWEST_ORDER = 2;
    private static final int HOTTEST_ORDER = 3;


    public static void movie(Context ctx){
        MovieParam param = new MovieParam(MovieTypeEnum.all.name(),
                MovieTypeEnum.all.getType(),MoviePlaceEnum.all.name(),
                MoviePlaceEnum.all.getType(),RECOMMEND_ORDER,0,0);
        movies(ctx,param);
    }

    public static void movie2(Context ctx){
        String[] filters = ParamUtil.getParam(ctx.pathParam("filter"));
        if (filters.length < 4)
            movie(ctx);
        else {
            MovieTypeEnum type = ParamUtil.getType(MovieTypeEnum.class, filters[0]);
            if (null == type)
                type = MovieTypeEnum.all;
            MoviePlaceEnum place = ParamUtil.getType(MoviePlaceEnum.class, filters[1]);
            if (null == place)
                place = MoviePlaceEnum.all;
            int order = ParamUtil.getInt(filters[2]);
            if (order != RECOMMEND_ORDER && order != NEWEST_ORDER && order != HOTTEST_ORDER)
                order = RECOMMEND_ORDER;
            int page = ParamUtil.getInt(filters[3]);
            page = page <=1 ? 0 : (page -1)*30;
            MovieParam param = new MovieParam(type.name(),type.getType(),place.name(),
                    place.getType(),order,page,0);
            movies(ctx,param);
        }
    }

    /**
     * 获取电影列表：
     * 过滤：类型、上映地点
     * 排序：推荐（id）[1]、最新（时间）[2]、最热（观看最多）[3]
     * 分页：page
     * @param ctx ctx
     * @param param 电影过滤参数
     */
    private static void movies(Context ctx, MovieParam param){
        SqlSession session = MybatisConfigure.getSession();
        MovieMapper mapper = session.getMapper(MovieMapper.class);
        List<SimpleMovie> movies = mapper.getMovies(param);
        int count = mapper.getMovieCount(param);
        session.close();
        param.setCount(count);
        param.setType_id(0);
        param.setPlace_id(0);
        ctx.render(Path.MOVIE_INDEX.web(),addMap("movies",movies,"movieParam",param));
    }

    /**
     * 电影详情
     * @param ctx ctx
     */
    public static void movieSrc(Context ctx){
        SqlSession session = MybatisConfigure.getSession();
        MovieMapper mapper = session.getMapper(MovieMapper.class);
        Movie movie = mapper.getMovie(ParamUtil.getInt(ctx.pathParam("id"), 1));
        session.close();
        ctx.render(Path.MOVIE_SRC.web(),addMap("movie",movie));
    }

}