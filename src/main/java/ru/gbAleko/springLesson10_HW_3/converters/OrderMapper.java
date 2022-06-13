package ru.gbAleko.springLesson10_HW_3.converters;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.factory.Mappers;
import ru.gbAleko.springLesson10_HW_3.dto.OrderDto;
import ru.gbAleko.springLesson10_HW_3.models.entities.Order;

public interface OrderMapper {

    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);

    Order toOrder(OrderDto orderDto);

    @InheritInverseConfiguration
    OrderDto fromOrder(Order order);
}
