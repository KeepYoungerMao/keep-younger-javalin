package com.mao.mapper.classical;

import com.mao.entity.classical.book.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 古籍
 * @author mao in 21:35 2019/12/5
 */
@Mapper
public interface BookMapper {

    //获取古籍列表
    List<SimpleBook> getBooks(BookParam bookParam);

    //获取古籍数量
    int getBookCount(BookParam bookParam);

    //获取古籍详情
    Book getBook(@Param("id") int id);

    //获取古籍章节列表
    List<BookChapter> getBookChapter(@Param("id") int id);

    //获取古籍章节详情
    BookChapterSrc getBookChapterSrc(@Param("id") int id);

}