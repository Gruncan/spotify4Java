package com.spotify.objects.test;

import java.util.Collection;

public interface IBookService {

    Collection<Book> getBooks();

    Book addBook(Book book);


}
