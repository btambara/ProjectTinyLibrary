package com.service.projecttinylibrary.converter;

import com.service.projecttinylibrary.dto.TinyLibraryDto;
import com.service.projecttinylibrary.entity.TinyLibrary;

import java.util.stream.Collectors;

public class TinyLibraryConverter {
    public static TinyLibrary dtoToEntity(TinyLibraryDto tinyLibraryDto) {
        return new TinyLibrary(
                tinyLibraryDto.getId(), tinyLibraryDto.getName(),
                tinyLibraryDto.getLocation(),
                tinyLibraryDto.getBooks().stream().map(BookConverter::dtoToEntity).collect(Collectors.toList()));
    }

    public static TinyLibraryDto entityToDto(TinyLibrary tinyLibrary) {
        return new TinyLibraryDto(
                tinyLibrary.getId(), tinyLibrary.getName(),
                tinyLibrary.getLocation(),
                tinyLibrary.getBooks().stream().map(BookConverter::entityToDto).collect(Collectors.toList()));
    }
}
