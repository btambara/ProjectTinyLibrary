package com.service.projecttinylibrary.service;

import com.service.projecttinylibrary.dto.TinyLibraryDto;

import java.util.List;

public interface TinyLibraryService {
    void wipeAllTinyLibraries();

    List<TinyLibraryDto> getNearbyTinyLibrary(Double lat, Double lng, Double maxDistance, String unit);

    List<TinyLibraryDto> getTinyLibraryByName(String name);

    List<TinyLibraryDto> getTinyLibraryByNameThatHas(String nameHas);

    List<TinyLibraryDto> getTinyLibraryWithBookType(String type);

    List<TinyLibraryDto> getTinyLibraryWithBookName(String title);

    List<TinyLibraryDto> getTinyLibraryWithBookNameThatHas(String bookNameHas);

    List<TinyLibraryDto> getTinyLibraryWithSummaryThatHas(String summaryHas);

    boolean addTinyLibrary(TinyLibraryDto tinyLibraryDto);

    boolean removeTinyLibrary(TinyLibraryDto tinyLibraryDto);

    boolean updateTinyLibrary(TinyLibraryDto tinyLibraryDto);
}
