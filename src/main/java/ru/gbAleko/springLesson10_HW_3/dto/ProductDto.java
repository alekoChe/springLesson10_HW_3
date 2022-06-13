package ru.gbAleko.springLesson10_HW_3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder//(toBuilder = true)
public class ProductDto {
    private Long id;
    private String title;
    private Integer price;
}
