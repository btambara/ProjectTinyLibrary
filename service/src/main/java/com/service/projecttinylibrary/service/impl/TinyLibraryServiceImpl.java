package com.service.projecttinylibrary.service.impl;

import com.service.projecttinylibrary.converter.TinyLibraryConverter;
import com.service.projecttinylibrary.dto.TinyLibraryDto;
import com.service.projecttinylibrary.entity.TinyLibrary;
import com.service.projecttinylibrary.repo.TinyLibraryRepo;
import com.service.projecttinylibrary.service.TinyLibraryService;
import com.service.projecttinylibrary.util.GeoDataSourceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TinyLibraryServiceImpl implements TinyLibraryService {
    private static Logger logger = LoggerFactory.getLogger(TinyLibraryServiceImpl.class);

    @Autowired
    TinyLibraryRepo tinyLibraryRepo;

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
        List<TinyLibraryDto> libraryByNameThatHasList =  tinyLibraryRepo.findByNameIgnoreCaseContains(nameHas).
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
    public boolean removeTinyLibrary(TinyLibraryDto tinyLibraryDto) {
        tinyLibraryRepo.delete(TinyLibraryConverter.dtoToEntity(tinyLibraryDto));
        return true;
    }

    @Override
    public boolean updateTinyLibrary(TinyLibraryDto tinyLibraryDto) {
        Optional<TinyLibrary> optionalTinyLibrary = tinyLibraryRepo.findById(tinyLibraryDto.getId());
        if (optionalTinyLibrary.isPresent()) {
            tinyLibraryRepo.save(TinyLibraryConverter.dtoToEntity(tinyLibraryDto));
            return true;
        }

        return false;
    }

    @Override
    public boolean addTinyLibrary(TinyLibraryDto tinyLibraryDto) {
        if (tinyLibraryDto.getBooks() == null) {
            tinyLibraryDto.setBooks(Collections.emptyList());
        }

        return tinyLibraryRepo.save(TinyLibraryConverter.dtoToEntity(tinyLibraryDto)) != null;
    }
}
