package ru.gbAleko.springLesson10_HW_3.converters;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.gbAleko.springLesson10_HW_3.dto.ProductDto;
import ru.gbAleko.springLesson10_HW_3.models.entities.Product;

@Mapper
public interface ProductMapper {
//    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);
//
//    Product toProduct(ProductDto productDto);
//
//    @InheritInverseConfiguration
//    ProductDto fromProduct(Product product);
}
