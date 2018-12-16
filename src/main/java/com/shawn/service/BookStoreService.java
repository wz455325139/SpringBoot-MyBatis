package com.shawn.service;

import java.util.List;
import java.util.Optional;

import com.shawn.model.entity.BookStore;
import com.shawn.model.entity.BookStoreWithBooks;

public interface BookStoreService {

    Optional<BookStore> getBookStoreById(Long id);

    List<String> getAllBookStoreNames();

    Optional<BookStoreWithBooks> getBookStoreWithBooksById(Long id);

}
