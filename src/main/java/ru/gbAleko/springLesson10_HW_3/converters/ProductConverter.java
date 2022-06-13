package ru.gbAleko.springLesson10_HW_3.converters;

import ru.gbAleko.springLesson10_HW_3.models.entities.Product;
import ru.gbAleko.springLesson10_HW_3.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getPrice(), null);
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }
}
