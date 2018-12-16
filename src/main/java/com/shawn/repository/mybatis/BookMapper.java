package com.shawn.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.shawn.model.entity.Book;
import com.shawn.repository.BookRepository;

@Mapper
public interface BookMapper extends BookRepository {

    @Override
    List<Book> selectBooksByLowPriceAndHighPrice(@Param("lowPrice") Double lowPrice,
        @Param("highPrice") Double highPrice);

    @Override
    List<Book> selectBooksByPage(@Param("offset") Integer offset, @Param("perPage") Integer perPage);

}
