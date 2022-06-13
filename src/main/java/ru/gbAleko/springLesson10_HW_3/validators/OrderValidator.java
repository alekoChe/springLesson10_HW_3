package ru.gbAleko.springLesson10_HW_3.validators;

import ru.gbAleko.springLesson10_HW_3.dto.OrderDto;
import ru.gbAleko.springLesson10_HW_3.dto.ProductDto;
import ru.gbAleko.springLesson10_HW_3.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class OrderValidator {

    public void validate(OrderDto orderDto) {
        List<String> errors = new ArrayList<>();
        if (orderDto.getOrderList().isEmpty()) {
            errors.add("Список покупок не может быть пуст");
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
