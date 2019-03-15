package com.service.projecttinylibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private String type;
    private String authorFirstName;
    private String authorLastName;
    private Integer quantity;
    private String title;
    private String summary;
}
