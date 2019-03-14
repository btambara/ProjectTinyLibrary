package com.service.projecttinylibrary.converter;

import com.service.projecttinylibrary.dto.BookDto;
import com.service.projecttinylibrary.entity.Book;

public class BookConverter {
    public static Book dtoToEntity(BookDto bookDto) {
        return new Book(bookDto.getType(), bookDto.getTitle(), bookDto.getSummary());
    }

    public static BookDto entityToDto(Book book) {
        return new BookDto(book.getType(), book.getTitle(), book.getSummary());
    }
}
