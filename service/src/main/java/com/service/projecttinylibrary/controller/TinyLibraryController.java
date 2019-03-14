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

    @GetMapping(value = "/search", params = "nameContains")
    public List<TinyLibraryDto> getTinyLibraryByNameThatContains(@RequestParam String nameContains) {
        return tinyLibraryService.getTinyLibraryByNameThatContains(nameContains);
    }
}
