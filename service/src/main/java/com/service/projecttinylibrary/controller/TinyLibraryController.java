package com.service.projecttinylibrary.controller;

import com.service.projecttinylibrary.dto.TinyLibraryDto;
import com.service.projecttinylibrary.service.TinyLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/search/book", params = "type")
    public List<TinyLibraryDto> getTinyLibraryByBookType(@RequestParam String type) {
        return tinyLibraryService.getTinyLibraryWithBookType(type);
    }

    @GetMapping(value = "/search/book", params = "title")
    public List<TinyLibraryDto> getTinyLibraryByBookTitle(@RequestParam String title) {
        return tinyLibraryService.getTinyLibraryWithBookName(title);
    }

    @GetMapping(value = "/search/book", params = "titlehas")
    public List<TinyLibraryDto> getTinyLibraryByBookTitleThatHas(@RequestParam String titlehas) {
        return tinyLibraryService.getTinyLibraryWithBookNameThatHas(titlehas);
    }

    @GetMapping(value = "/search/book", params = "summaryhas")
    public List<TinyLibraryDto> getTinyLibraryByBookSummaryThatHas(@RequestParam String summaryhas) {
        return tinyLibraryService.getTinyLibraryWithSummaryThatHas(summaryhas);
    }
}
