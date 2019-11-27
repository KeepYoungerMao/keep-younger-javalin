package com.mao.mapper;

import com.mao.entity.about.FeedBack;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mao by 14:39 2019/11/21
 */
@Mapper
public interface FeedbackMapper {

    void saveFeedBack(FeedBack feedBack);

}