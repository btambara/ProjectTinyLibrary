package com.service.projecttinylibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {
    private String type;
    private String title;
    private String summary;
}
