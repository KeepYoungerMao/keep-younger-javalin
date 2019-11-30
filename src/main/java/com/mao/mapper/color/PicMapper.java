package com.mao.mapper.color;

import com.mao.entity.color.PicMainClass;
import com.mao.entity.color.PicParam;
import com.mao.entity.color.PicSubClass;
import com.mao.entity.color.SimplePic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author mao in 22:35 2019/11/29
 */
@Mapper
public interface PicMapper {

    List<PicMainClass> getPicMainClass();

    List<PicSubClass> getPicSubClass();

    List<SimplePic> getPic(PicParam picParam);

}