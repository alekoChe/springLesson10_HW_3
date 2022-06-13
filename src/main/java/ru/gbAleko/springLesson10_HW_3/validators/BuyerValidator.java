package ru.gbAleko.springLesson10_HW_3.validators;

import org.springframework.stereotype.Component;
import ru.gbAleko.springLesson10_HW_3.dto.BuyerDto;
import ru.gbAleko.springLesson10_HW_3.dto.ProductDto;
import ru.gbAleko.springLesson10_HW_3.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuyerValidator {

    public void validate(BuyerDto buyerDto) {

        List<String> errors = new ArrayList<>();

        if (buyerDto.getPhoneNumber().length() < 6) {
            errors.add("Длина номера телефона не может быть меньше 6");
        }
        if (buyerDto.getName().isBlank()) {
            errors.add("Имя клиента не может иметь пустое название");
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
