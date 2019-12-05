package com.mao.mapper.classical;

import com.mao.entity.classical.idiom.Idiom;
import com.mao.entity.classical.idiom.IdiomParam;
import com.mao.entity.classical.idiom.SimpleIdiom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 成语
 * @author mao by 10:31 2019/12/5
 */
@Mapper
public interface IdiomMapper {

    //获取成语列表
    List<SimpleIdiom> getIdiom(IdiomParam idiomParam);

    //获取成语详情
    Idiom getIdiomSrc(@Param("id") int id);

    //获取总数
    int getIdiomCount(@Param("sp") String sp);

}