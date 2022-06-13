package ru.gbAleko.springLesson10_HW_3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gbAleko.springLesson10_HW_3.models.entities.Buyer;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder//(toBuilder = true)
public class OrderDto {

    private Long id;
    private Buyer buyer;
    private Map<ProductDto, Integer> orderList;
}
