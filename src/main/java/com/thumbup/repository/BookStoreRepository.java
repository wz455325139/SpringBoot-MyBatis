package com.thumbup.repository;

import java.util.List;

import com.thumbup.model.entity.BookStore;
import com.thumbup.model.entity.BookStoreWithBooks;

public interface BookStoreRepository {

    BookStore selectBookStoreById(Long id);

    List<BookStore> selectAllBookStores();

    BookStoreWithBooks selectBookStoreWithBooksById(Long id);

}
