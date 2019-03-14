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
                                new BookDto("Horror", "Murder on Elf Street", "This is just a murder book"),
                                new BookDto("Science Fiction", "Star Joys", "This is just a science fiction book"),
                                new BookDto("Documentary", "Alburt Edisun", "This is just a Alburt Edisun book")
                        )
                )
        );

        tinyLibraryService.addTinyLibrary(
                new TinyLibraryDto(
                        null,
                        "Los Angeles 4",
                        new GeoJsonPoint(34.052235, -118.193683),
                        Arrays.asList(
                                new BookDto("Horror", "Murder of Something", "This is just a murder book"),
                                new BookDto("Comedy", "Laugh your Socks off", "This is just a comedy book"),
                                new BookDto("Fiction", "Not true", "This is just a fiction book"),
                                new BookDto("Documentary", "Elon Mask", "This is just a Elon Mask book")
                        )
                )
        );

        tinyLibraryService.addTinyLibrary(
                new TinyLibraryDto(
                        null,
                        "Los Angeles 5",
                        new GeoJsonPoint(34.022235, -118.053683),
                        Arrays.asList(
                                new BookDto("Self Help", "Shift Your Thinking", "This is just a self help book"),
                                new BookDto("Science Fiction", "Star Trak", "This is just a star trak book"),
                                new BookDto("Documentary", "Elon Mask", "This is just a Elon Mask book")
                        )
                )
        );
    }

}
