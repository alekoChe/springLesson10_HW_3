package ru.gbAleko.springLesson10_HW_3.converters;

import org.springframework.stereotype.Component;
import ru.gbAleko.springLesson10_HW_3.dto.BuyerDto;
import ru.gbAleko.springLesson10_HW_3.models.entities.Buyer;

@Component
public class BuyerConverter {

    public Buyer dtoToEntity(BuyerDto buyerDto) {
        return new Buyer(buyerDto.getId(), buyerDto.getName(), buyerDto.getPhoneNumber(), null);
    }

    public BuyerDto entityToDto(Buyer buyer) {
        return new BuyerDto(buyer.getId(), buyer.getName(), buyer.getPhoneNumber());
    }
}
