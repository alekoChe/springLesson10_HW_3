package ru.gbAleko.springLesson10_HW_3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gbAleko.springLesson10_HW_3.dto.ProductDto;
import ru.gbAleko.springLesson10_HW_3.models.entities.Buyer;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Cart {

    private Buyer buyer;

    private Map<ProductDto, Integer> cartList;

    @PostConstruct
    public void init() {
        cartList = new HashMap<>();
    }
}
