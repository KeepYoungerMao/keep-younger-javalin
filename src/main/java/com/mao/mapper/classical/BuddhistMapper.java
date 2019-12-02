package com.mao.mapper.classical;

import com.mao.entity.classical.buddhist.Buddhist;
import com.mao.entity.classical.buddhist.BuddhistChapter;
import com.mao.entity.classical.buddhist.BuddhistChapterSrc;
import com.mao.entity.classical.buddhist.SimpleBuddhist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mao by 14:16 2019/12/2
 */
@Mapper
public interface BuddhistMapper {

    List<SimpleBuddhist> getBuddhist();

    Buddhist getBuddhistSrc(@Param("id") int id);

    List<BuddhistChapter> getBuddhistChapter(@Param("id") int id);

    BuddhistChapterSrc getBuddhistChapterSrc(@Param("id") int id);

}