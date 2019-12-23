package com.mao.mapper.ray;

import com.mao.entity.ray.movie.Movie;
import com.mao.entity.ray.movie.MovieParam;
import com.mao.entity.ray.movie.SimpleMovie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 电影 数据请求
 * @author mao by 14:54 2019/12/23
 */
@Mapper
public interface MovieMapper {

    //获取电影列表
    List<SimpleMovie> getMovies(MovieParam movieParam);

    //获取电影数量
    int getMovieCount(MovieParam movieParam);

    //获取电影详情
    Movie getMovie(@Param("id") int id);

}