package com.service.projecttinylibrary.service.impl;

import com.service.projecttinylibrary.converter.BookConverter;
import com.service.projecttinylibrary.converter.TinyLibraryConverter;
import com.service.projecttinylibrary.dto.BookDto;
import com.service.projecttinylibrary.dto.TinyLibraryDto;
import com.service.projecttinylibrary.entity.Book;
import com.service.projecttinylibrary.entity.TinyLibrary;
import com.service.projecttinylibrary.repo.TinyLibraryRepo;
import com.service.projecttinylibrary.service.TinyLibraryService;
import com.service.projecttinylibrary.util.GeoDataSourceUtils;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TinyLibraryServiceImpl implements TinyLibraryService {
    private static Logger logger = LoggerFactory.getLogger(TinyLibraryServiceImpl.class);

    @Autowired
    private TinyLibraryRepo tinyLibraryRepo;

    @Override
    public void wipeAllTinyLibraries() {
        tinyLibraryRepo.deleteAll();
    }

    @Override
    public List<TinyLibraryDto> getNearbyTinyLibrary(Double lat, Double lng, Double maxDistance, String unit) {
        logger.debug("lat: " + lat + " lng: " + lng + " maxDistance: " + maxDistance + " unit: " + unit);
        List<TinyLibraryDto> nearByLibrariesList = tinyLibraryRepo.findAll().stream().map(TinyLibraryConverter::entityToDto).filter(
                tl -> maxDistance >= GeoDataSourceUtils.distance(lat, lng, tl.getLocation().getX(), tl.getLocation().getY(), unit)
        ).collect(Collectors.toList());
        logger.debug("nearByLibrariesList: " + nearByLibrariesList);

        return nearByLibrariesList;
    }

    @Override
    public List<TinyLibraryDto> getTinyLibraryByNameThatHas(String nameHas) {
        logger.debug("nameHas: " + nameHas);
        List<TinyLibraryDto> libraryByNameThatHasList = tinyLibraryRepo.findByNameIgnoreCaseContains(nameHas).
                stream().
                map(TinyLibraryConverter::entityToDto).
                collect(Collectors.toList());
        logger.debug("libraryByNameThatHasList: " + libraryByNameThatHasList);

        return libraryByNameThatHasList;
    }

    @Override
    public List<TinyLibraryDto> getTinyLibraryByName(String name) {
        logger.debug("name: " + name);
        List<TinyLibraryDto> libraryByNameList = tinyLibraryRepo.findByNameIgnoreCase(name).
                stream().
                map(TinyLibraryConverter::entityToDto).
                collect(Collectors.toList());
        logger.debug("libraryByNameList: " + libraryByNameList);

        return libraryByNameList;
    }


    @Override
    public List<TinyLibraryDto> getTinyLibraryWithSummaryThatHas(String summaryHas) {
        logger.debug("summaryHas: " + summaryHas);
        List<TinyLibraryDto> libraryWithBookSummaryHasList = tinyLibraryRepo.findByBooksSummaryIgnoreCaseContains(summaryHas).
                stream().
                map(TinyLibraryConverter::entityToDto).
                collect(Collectors.toList());
        logger.debug("libraryWithBookSummaryHasList: " + libraryWithBookSummaryHasList);

        return libraryWithBookSummaryHasList;
    }

    @Override
    public void addTinyLibrary(TinyLibraryDto tinyLibraryDto) {
        logger.debug("tinyLibraryDto: " + tinyLibraryDto);
        if (tinyLibraryDto.getBooks() == null) {
            tinyLibraryDto.setBooks(new ArrayList<>());
        }
        tinyLibraryRepo.save(TinyLibraryConverter.dtoToEntity(tinyLibraryDto));
        logger.debug("[SUCCESS-ADD] tinyLibraryDto: " + tinyLibraryDto);
    }

    @Override
    public boolean updateTinyLibrary(TinyLibraryDto tinyLibraryDto) {
        logger.debug("tinyLibraryDto: " + tinyLibraryDto);
        Optional<TinyLibrary> tinyLibraryOptional = tinyLibraryRepo.findById(tinyLibraryDto.getId());
        if (tinyLibraryOptional.isPresent()) {
            tinyLibraryRepo.save(tinyLibraryOptional.get());
            logger.debug("[SUCCESS-UPDATE] tinyLibraryDto: " + tinyLibraryDto);
            return true;
        }

        logger.debug("[FAILED-updateTinyLibrary] " + tinyLibraryDto);
        return false;
    }

    @Override
    public boolean removeTinyLibrary(ObjectId tinyLibraryID) {
        logger.debug("tinyLibraryID: " + tinyLibraryID);
        Optional<TinyLibrary> tinyLibraryOptional = tinyLibraryRepo.findById(tinyLibraryID);
        if (tinyLibraryOptional.isPresent()) {
            tinyLibraryRepo.delete(tinyLibraryOptional.get());
            logger.debug("[SUCCESS-REMOVE] tinyLibraryID: " + tinyLibraryID);
            return true;
        }

        logger.debug("[FAILED-removeTinyLibrary] tinyLibraryID: " + tinyLibraryID);
        return false;
    }

    @Override
    public List<TinyLibraryDto> getTinyLibraryWithBookType(String type) {
        logger.debug("type: " + type);
        List<TinyLibraryDto> libraryWithBookTypeList = tinyLibraryRepo.findByBooksTypeIgnoreCase(type).
                stream().
                map(TinyLibraryConverter::entityToDto).
                collect(Collectors.toList());
        logger.debug("libraryWithBookTypeList: " + libraryWithBookTypeList);

        return libraryWithBookTypeList;
    }

    @Override
    public List<TinyLibraryDto> getTinyLibraryWithBookName(String title) {
        logger.debug("title: " + title);
        List<TinyLibraryDto> libraryWithBookNameList = tinyLibraryRepo.findByBooksTitleIgnoreCase(title).
                stream().
                map(TinyLibraryConverter::entityToDto).
                collect(Collectors.toList());
        logger.debug("libraryWithBookNameList: " + libraryWithBookNameList);

        return libraryWithBookNameList;
    }

    @Override
    public List<TinyLibraryDto> getTinyLibraryWithBookNameThatHas(String titleHas) {
        logger.debug("titleHas: " + titleHas);
        List<TinyLibraryDto> libraryWithBookNameHasList = tinyLibraryRepo.findByBooksTitleIgnoreCaseContains(titleHas).
                stream().
                map(TinyLibraryConverter::entityToDto).
                collect(Collectors.toList());
        logger.debug("libraryWithBookNameHasList: " + libraryWithBookNameHasList);

        return libraryWithBookNameHasList;
    }

    @Override
    public boolean addBookToTinyLibrary(BookDto bookDto, ObjectId id) {
        logger.debug("bookDto: " + bookDto + "id: " + id);
        Optional<TinyLibrary> tinyLibraryOptional = tinyLibraryRepo.findById(id);
        if (tinyLibraryOptional.isPresent()) {
            TinyLibrary tinyLibrary = tinyLibraryOptional.get();
            if (tinyLibrary.getBooks().stream().anyMatch(
                    b -> b.getAuthorFirstName().equalsIgnoreCase(bookDto.getAuthorFirstName()) &&
                            b.getAuthorLastName().equalsIgnoreCase(bookDto.getAuthorLastName()) &&
                            b.getType().equalsIgnoreCase(bookDto.getType()) &&
                            b.getTitle().equalsIgnoreCase(bookDto.getTitle()))) {
                Optional<Book> bookOptional = tinyLibrary.getBooks().stream().filter(b -> b.getTitle().equalsIgnoreCase(bookDto.getTitle())).findFirst();
                if (bookOptional.isPresent()) {
                    Book currentBook = bookOptional.get();
                    int currentBookQuantity = currentBook.getQuantity();
                    int currentBookIndex = tinyLibrary.getBooks().indexOf(currentBook);
                    tinyLibrary.getBooks().get(currentBookIndex).setQuantity(currentBookQuantity + bookDto.getQuantity());
                    logger.debug("[UPDATED-BOOK-QUANTITY] " + bookDto);
                }
            } else {
                logger.debug("[ADDED-BOOK] " + bookDto);
                tinyLibrary.getBooks().add(BookConverter.dtoToEntity(bookDto));
            }
            tinyLibraryRepo.save(tinyLibrary);
            logger.debug("[SUCCESS-addBookToTinyLibrary] " + bookDto);
            return true;
        }

        logger.debug("[FAILED-addBookToTinyLibrary] " + bookDto);
        return false;
    }

    @Override
    public boolean removeBookToTinyLibrary(BookDto bookDto, ObjectId id) {
        logger.debug("bookDto: " + bookDto + "id: " + id);
        Optional<TinyLibrary> tinyLibraryOptional = tinyLibraryRepo.findById(id);
        if (tinyLibraryOptional.isPresent()) {
            TinyLibrary tinyLibrary = tinyLibraryOptional.get();
            if (tinyLibrary.getBooks().stream().anyMatch(
                    b -> b.getAuthorFirstName().equalsIgnoreCase(bookDto.getAuthorFirstName()) &&
                            b.getAuthorLastName().equalsIgnoreCase(bookDto.getAuthorLastName()) &&
                            b.getType().equalsIgnoreCase(bookDto.getType()) &&
                            b.getTitle().equalsIgnoreCase(bookDto.getTitle()))) {
                Optional<Book> bookOptional = tinyLibrary.getBooks().stream().filter(b -> b.getTitle().equalsIgnoreCase(bookDto.getTitle())).findFirst();
                if (bookOptional.isPresent()) {
                    Book currentBook = bookOptional.get();
                    int currentBookQuantity = currentBook.getQuantity();
                    int currentBookIndex = tinyLibrary.getBooks().indexOf(currentBook);
                    int newBookQuantity = currentBookQuantity - bookDto.getQuantity();
                    if (newBookQuantity >= 0) {
                        if (newBookQuantity != 0) {
                            tinyLibrary.getBooks().get(currentBookIndex).setQuantity(currentBookQuantity - bookDto.getQuantity());
                            logger.debug("[UPDATED-BOOK-QUANTITY] " + bookDto);
                        } else {
                            tinyLibrary.getBooks().remove(currentBookIndex);
                            logger.debug("[REMOVED-BOOK] " + bookDto);
                        }
                        tinyLibraryRepo.save(tinyLibrary);
                        logger.debug("[SUCCESS-removeBookToTinyLibrary] " + bookDto);
                        return true;
                    } else {
                        logger.debug("[FAILED-removeBookToTinyLibrary] " + bookDto);
                        return false;
                    }
                }
            }
        }

        logger.debug("[FAILED-removeBookToTinyLibrary] " + bookDto);
        return false;
    }

    @Override
    public boolean updateBookToTinyLibrary(BookDto bookDto, ObjectId id) {
        logger.debug("bookDto: " + bookDto + "id: " + id);
        Optional<TinyLibrary> tinyLibraryOptional = tinyLibraryRepo.findById(id);
        if (tinyLibraryOptional.isPresent()) {
            TinyLibrary tinyLibrary = tinyLibraryOptional.get();
            if (tinyLibrary.getBooks().stream().anyMatch(
                    b -> b.getAuthorFirstName().equalsIgnoreCase(bookDto.getAuthorFirstName()) &&
                            b.getAuthorLastName().equalsIgnoreCase(bookDto.getAuthorLastName()) &&
                            b.getType().equalsIgnoreCase(bookDto.getType()) &&
                            b.getTitle().equalsIgnoreCase(bookDto.getTitle()))) {
                Optional<Book> bookOptional = tinyLibrary.getBooks().stream().filter(b -> b.getTitle().equalsIgnoreCase(bookDto.getTitle())).findFirst();
                if (bookOptional.isPresent()) {
                    Book currentBook = bookOptional.get();
                    int currentBookIndex = tinyLibrary.getBooks().indexOf(currentBook);
                    if (bookDto.getQuantity() >= 0) {
                        tinyLibrary.getBooks().remove(currentBookIndex);
                        logger.debug("[REMOVED-BOOK] " + bookDto);
                        if (bookDto.getQuantity() != 0) {
                            logger.debug("[UPDATED-BOOK] " + bookDto);
                            tinyLibrary.getBooks().add(BookConverter.dtoToEntity(bookDto));
                        }
                        tinyLibraryRepo.save(tinyLibrary);
                        logger.debug("[SUCCESS-updateBookToTinyLibrary] " + bookDto);
                        return true;
                    }
                }
            }
        }

        logger.debug("[FAILED-updateBookToTinyLibrary] " + bookDto);
        return false;
    }
}
