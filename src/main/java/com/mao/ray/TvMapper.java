package com.mao.ray;

import com.mao.entity.ray.M3u8;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author mao by 11:02 2019/11/9
 */
@Mapper
public interface TvMapper {

    List<M3u8> getTvs();

}