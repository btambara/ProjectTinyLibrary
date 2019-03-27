package com.service.projecttinylibrary;

import com.service.projecttinylibrary.dto.BookDto;
import com.service.projecttinylibrary.dto.TinyLibraryDto;
import com.service.projecttinylibrary.service.TinyLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class ProjectTinyLibraryApplication {
    @Autowired
    private static TinyLibraryService tinyLibraryService;

    public ProjectTinyLibraryApplication(TinyLibraryService tinyLibraryService) {
        ProjectTinyLibraryApplication.tinyLibraryService = tinyLibraryService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectTinyLibraryApplication.class, args);

        tinyLibraryService.wipeAllTinyLibraries();

        tinyLibraryService.addTinyLibrary(
                new TinyLibraryDto(
                        null,
                        "Los Angeles 1",
                        new GeoJsonPoint(34.052235, -118.243683),
                        null
                )
        );

        tinyLibraryService.addTinyLibrary(
                new TinyLibraryDto(
                        null,
                        "Los Angeles 2",
                        new GeoJsonPoint(34.052235, -118.043683),
                        Collections.emptyList()
                )
        );

        tinyLibraryService.addTinyLibrary(
                new TinyLibraryDto(
                        null,
                        "Los Angeles 3",
                        new GeoJsonPoint(34.052235, -118.111111),
                        Arrays.asList(
                                new BookDto("Horror", "Joe", "Davis", 1, "Murder on Elf Street", "This is just a murder book"),
                                new BookDto("Science Fiction", "George", "Bucas", 1, "Star Joys", "This is just a science fiction book"),
                                new BookDto("Documentary", "Albert", "Edison", 1, "Alburt Edisun", "This is just a Alburt Edisun book")
                        )
                )
        );

        tinyLibraryService.addTinyLibrary(
                new TinyLibraryDto(
                        null,
                        "Los Angeles 4",
                        new GeoJsonPoint(34.052235, -118.193683),
                        Arrays.asList(
                                new BookDto("Horror", "Hog", "Willy", 1, "Murder of Something", "This is just a murder book"),
                                new BookDto("Comedy", "Adam", "Sandal", 1, "Laugh your Socks off", "This is just a comedy book"),
                                new BookDto("Fiction", "Notah", "Name", 1, "Not true", "This is just a fiction book"),
                                new BookDto("Documentary", "Elon", "Musk", 1, "Elon Mask", "This is just a Elon Mask book")
                        )
                )
        );

        tinyLibraryService.addTinyLibrary(
                new TinyLibraryDto(
                        null,
                        "Los Angeles 5",
                        new GeoJsonPoint(34.022235, -118.053683),
                        Arrays.asList(
                                new BookDto("Self Help", "You", "You", 1, "Shift Your Thinking", "This is just a self help book"),
                                new BookDto("Science Fiction", "Darth", "Vader", 1, "Star Trak", "This is just a star trak book"),
                                new BookDto("Documentary", "Elon", "Must", 1, "Elon Mask", "This is just a Elon Mask book")
                        )
                )
        );
    }

}
