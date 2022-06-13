package ru.gbAleko.springLesson10_HW_3.converters;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.gbAleko.springLesson10_HW_3.dto.BuyerDto;
import ru.gbAleko.springLesson10_HW_3.models.entities.Buyer;


@Mapper
public interface BuyerMapper {

    BuyerMapper MAPPER = Mappers.getMapper(BuyerMapper.class);
    Buyer toBuyer(BuyerDto buyerDto);

    @InheritInverseConfiguration
    BuyerDto fromBuyer(Buyer buyer);
}
