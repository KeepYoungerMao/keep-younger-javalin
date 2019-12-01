package com.mao.mapper.color;

import com.mao.entity.color.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mao in 22:35 2019/11/29
 */
@Mapper
public interface PicMapper {

    List<PicMainClass> getPicMainClass();

    List<PicSubClass> getPicSubClass();

    List<SimplePic> getPic(PicParam picParam);

    int getPicCount(@Param("id") int id);

    Pic getPicSrc(@Param("id") int id);

}