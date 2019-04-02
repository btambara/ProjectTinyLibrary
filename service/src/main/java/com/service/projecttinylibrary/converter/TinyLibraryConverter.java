package com.service.projecttinylibrary.converter;

import com.service.projecttinylibrary.dto.TinyLibraryDto;
import com.service.projecttinylibrary.entity.TinyLibrary;
import org.bson.types.ObjectId;

import java.util.stream.Collectors;

public class TinyLibraryConverter {
    public static TinyLibrary dtoToEntity(TinyLibraryDto tinyLibraryDto) {
        return new TinyLibrary(
                new ObjectId(tinyLibraryDto.getObjectIDHexString() == null || tinyLibraryDto.getObjectIDHexString().isEmpty() ? ObjectId.get().toHexString() : tinyLibraryDto.getObjectIDHexString()),
                tinyLibraryDto.getName(),
                tinyLibraryDto.getLocation(),
                tinyLibraryDto.getBooks().stream().map(BookConverter::dtoToEntity).collect(Collectors.toList()));
    }

    public static TinyLibraryDto entityToDto(TinyLibrary tinyLibrary) {
        return new TinyLibraryDto(
                tinyLibrary.getId().toHexString(), tinyLibrary.getName(),
                tinyLibrary.getLocation(),
                tinyLibrary.getBooks().stream().map(BookConverter::entityToDto).collect(Collectors.toList()));
    }
}
