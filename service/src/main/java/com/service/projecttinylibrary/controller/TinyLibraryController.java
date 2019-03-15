package com.service.projecttinylibrary.controller;

import com.service.projecttinylibrary.dto.BookDto;
import com.service.projecttinylibrary.dto.TinyLibraryDto;
import com.service.projecttinylibrary.service.TinyLibraryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class TinyLibraryController {
    @Autowired
    private TinyLibraryService tinyLibraryService;

    @GetMapping("/nearby")
    public List<TinyLibraryDto> getNearbyTinyLibrary(@RequestParam Double lat, @RequestParam Double lng, @RequestParam Double maxDistance, @RequestParam String unit) {
        return tinyLibraryService.getNearbyTinyLibrary(lat, lng, maxDistance, unit);
    }

    @GetMapping(value = "/search", params = "name")
    public List<TinyLibraryDto> getTinyLibraryByName(@RequestParam String name) {
        return tinyLibraryService.getTinyLibraryByName(name);
    }

    @GetMapping(value = "/search", params = "namehas")
    public List<TinyLibraryDto> getTinyLibraryByNameThatHas(@RequestParam String namehas) {
        return tinyLibraryService.getTinyLibraryByNameThatHas(namehas);
    }

    @PostMapping
    public void addTinyLibrary(@RequestBody TinyLibraryDto tinyLibraryDto) {
        tinyLibraryService.addTinyLibrary(tinyLibraryDto);
    }

    @PutMapping
    public void updateTinyLibrary(@RequestBody TinyLibraryDto tinyLibraryDto) {
        tinyLibraryService.updateTinyLibrary(tinyLibraryDto);
    }

    @DeleteMapping(params = "id")
    public void removeTinyLibrary(@RequestParam String id) {
        tinyLibraryService.removeTinyLibrary(new ObjectId(id));
    }

    @GetMapping(value = "/book/search", params = "type")
    public List<TinyLibraryDto> getTinyLibraryByBookType(@RequestParam String type) {
        return tinyLibraryService.getTinyLibraryWithBookType(type);
    }

    @GetMapping(value = "/book/search", params = "title")
    public List<TinyLibraryDto> getTinyLibraryByBookTitle(@RequestParam String title) {
        return tinyLibraryService.getTinyLibraryWithBookName(title);
    }

    @GetMapping(value = "/book/search", params = "titlehas")
    public List<TinyLibraryDto> getTinyLibraryByBookTitleThatHas(@RequestParam String titlehas) {
        return tinyLibraryService.getTinyLibraryWithBookNameThatHas(titlehas);
    }

    @GetMapping(value = "/book/search", params = "summaryhas")
    public List<TinyLibraryDto> getTinyLibraryByBookSummaryThatHas(@RequestParam String summaryhas) {
        return tinyLibraryService.getTinyLibraryWithSummaryThatHas(summaryhas);
    }

    @PostMapping(value = "book", params = "id")
    public void addBookToTinyLibrary(@RequestBody BookDto bookDto, @RequestParam String id) {
        tinyLibraryService.addBookToTinyLibrary(bookDto, new ObjectId(id));
    }

    @PutMapping(value = "book", params = "id")
    public void updateBookInTinyLibrary(@RequestBody BookDto bookDto, @RequestParam String id) {
        tinyLibraryService.updateBookToTinyLibrary(bookDto, new ObjectId(id));
    }

    @DeleteMapping(value = "book", params = "id")
    public void removeBookInTinyLibrary(@RequestBody BookDto bookDto, @RequestParam String id) {
        tinyLibraryService.removeBookToTinyLibrary(bookDto, new ObjectId(id));
    }
}
