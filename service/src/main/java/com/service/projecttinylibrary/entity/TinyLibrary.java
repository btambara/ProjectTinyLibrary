package com.service.projecttinylibrary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("tiny-libraries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TinyLibrary {
    private ObjectId id;
    private String name;
    private GeoJsonPoint location;
    private List<Book> books;
}
