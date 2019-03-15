package com.service.projecttinylibrary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String type;
    private String authorFirstName;
    private String authorLastName;
    private Integer quantity;
    private String title;
    private String summary;
}
