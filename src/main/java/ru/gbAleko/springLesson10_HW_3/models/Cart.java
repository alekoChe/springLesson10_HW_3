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
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Cart {

    private Buyer buyer;
    private ProductDto productDto;
    private Integer numberProducts;

    private Map<ProductDto, Integer> cartList;

    @PostConstruct
    public void init() {
        cartList = new HashMap<>();
    }

    public void deleteProductFromCartList(ProductDto productDto) {
        cartList.remove(productDto);
    }
    public void addProductIntoCart(ProductDto productDto, Integer numberProducts) {
        if (!cartList.containsKey(productDto)) {
            cartList.put(productDto, numberProducts);
        } else {
            cartList.put(productDto, cartList.get(productDto) + numberProducts);
        }
    }

    private Map<ProductDto, Integer> getCartList() {
        return cartList;
    }
}
