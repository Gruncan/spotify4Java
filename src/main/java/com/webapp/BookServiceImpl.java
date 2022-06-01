package com.webapp;

import com.spotify.objects.test.Book;
import com.spotify.objects.test.DuplicateBookException;
import com.spotify.objects.test.IBookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    private List<Book> bookRepository;

    public BookServiceImpl() {
        this.bookRepository = new ArrayList<>();
    }

    @Override
    public Collection<Book> getBooks() {
        return this.bookRepository;
    }

    @Override
    public Book addBook(Book book) {

        if (this.bookRepository.contains(book)) {
            throw new DuplicateBookException(book);
        }

        this.bookRepository.add(book);
        return book;
    }
}
