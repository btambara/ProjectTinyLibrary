package com.service.projecttinylibrary.service;

import com.service.projecttinylibrary.dto.TinyLibraryDto;

import java.util.List;

public interface TinyLibraryService {
    void wipeAllTinyLibraries();

    List<TinyLibraryDto> getNearbyTinyLibrary(Double lat, Double lng, Double maxDistance, String unit);

    List<TinyLibraryDto> getTinyLibraryByName(String name);

    List<TinyLibraryDto> getTinyLibraryByNameThatContains(String nameContains);

    boolean addTinyLibrary(TinyLibraryDto tinyLibraryDto);

    boolean removeTinyLibrary(TinyLibraryDto tinyLibraryDto);

    boolean updateTinyLibrary(TinyLibraryDto tinyLibraryDto);
}
