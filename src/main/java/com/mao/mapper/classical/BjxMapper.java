package com.mao.mapper.classical;

import com.mao.entity.classical.bjx.Bjx;
import com.mao.entity.classical.bjx.BjxParam;
import com.mao.entity.classical.bjx.BjxSrc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 百家姓
 * @author mao in 22:34 2019/12/3
 */
@Mapper
public interface BjxMapper {

    List<Bjx> getBjx(BjxParam bjxParam);

    BjxSrc getBjxSrc(@Param("id") int id);

}