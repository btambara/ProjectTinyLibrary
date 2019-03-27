package com.service.projecttinylibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TinyLibraryDto {
    private String objectIDHexString;
    private String name;
    private GeoJsonPoint location;
    private List<BookDto> books;
}
