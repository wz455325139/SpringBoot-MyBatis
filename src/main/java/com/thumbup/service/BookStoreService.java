package com.thumbup.service;

import java.util.List;
import java.util.Optional;

import com.thumbup.model.entity.BookStore;
import com.thumbup.model.entity.BookStoreWithBooks;

public interface BookStoreService {

    Optional<BookStore> getBookStoreById(Long id);

    List<String> getAllBookStoreNames();

    Optional<BookStoreWithBooks> getBookStoreWithBooksById(Long id);

}
