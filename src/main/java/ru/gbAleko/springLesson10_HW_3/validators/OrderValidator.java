package ru.gbAleko.springLesson10_HW_3.validators;

import ru.gbAleko.springLesson10_HW_3.dto.ProductDto;
import ru.gbAleko.springLesson10_HW_3.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class OrderValidator {
    public void validate(ProductDto productDto) {
        List<String> errors = new ArrayList<>();
        if (productDto.getPrice() < 1) {
            errors.add("Цена продукта не может быть меньше 1");
        }
        if (productDto.getTitle().isBlank()) {
            errors.add("Продукт не может иметь пустое название");
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }

        if ()
    }
}
