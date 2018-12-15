package com.shawn.repository;

import java.util.List;

import com.shawn.model.entity.BookStore;
import com.shawn.model.entity.BookStoreWithBooks;

public interface BookStoreRepository {

    BookStore selectBookStoreById(Long id);

    List<BookStore> selectAllBookStores();

    BookStoreWithBooks selectBookStoreWithBooksById(Long id);

}
