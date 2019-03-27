package com.service.projecttinylibrary.service;

import com.service.projecttinylibrary.dto.BookDto;
import com.service.projecttinylibrary.dto.TinyLibraryDto;
import org.bson.types.ObjectId;

import java.util.List;

public interface TinyLibraryService {
    void wipeAllTinyLibraries();

    TinyLibraryDto getTinyLibrary(ObjectId tinyLibraryID);

    List<TinyLibraryDto> getNearbyTinyLibrary(Double lat, Double lng, Double maxDistance, String unit);

    List<TinyLibraryDto> getTinyLibraryByName(String name);

    List<TinyLibraryDto> getTinyLibraryByNameThatHas(String nameHas);

    void addTinyLibrary(TinyLibraryDto tinyLibraryDto);

    boolean updateTinyLibrary(TinyLibraryDto tinyLibraryDto);

    boolean removeTinyLibrary(ObjectId tinyLibraryID);

    List<TinyLibraryDto> getTinyLibraryWithBookType(String type);

    List<TinyLibraryDto> getTinyLibraryWithBookName(String title);

    List<TinyLibraryDto> getTinyLibraryWithBookNameThatHas(String bookNameHas);

    List<TinyLibraryDto> getTinyLibraryWithSummaryThatHas(String summaryHas);

    boolean addBookToTinyLibrary(BookDto bookDto, ObjectId tinyLibraryID);

    boolean removeBookToTinyLibrary(BookDto bookDto, ObjectId tinyLibraryID);

    boolean updateBookToTinyLibrary(BookDto bookDto, ObjectId tinyLibraryID);

    boolean updateBooksToTinyLibrary(BookDto[] bookDto, ObjectId tinyLibraryID);
}
