package ru.gbAleko.springLesson10_HW_3.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gbAleko.springLesson10_HW_3.converters.OrderMapper;
import ru.gbAleko.springLesson10_HW_3.dto.OrderDto;
import ru.gbAleko.springLesson10_HW_3.dto.ProductDto;
import ru.gbAleko.springLesson10_HW_3.models.entities.Order;
import ru.gbAleko.springLesson10_HW_3.models.entities.Product;
import ru.gbAleko.springLesson10_HW_3.services.CartService;
import ru.gbAleko.springLesson10_HW_3.services.OrderService;
import ru.gbAleko.springLesson10_HW_3.validators.OrderValidator;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final OrderValidator orderValidator;
    private final OrderMapper orderMapper;
    //private final OrderService orderService;

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        cartService.deleteById(id);
    }

    @GetMapping("/{id}")
    public void addProductById(@RequestParam Long productId) {
        cartService.addProductIntoCart(productId);
    }

    @PostMapping  /////////////////////////////////////////////////////////////
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        Product product = productConverter.dtoToEntity(productDto);
        //Product product = productMapper.MAPPER.toProduct(productDto);
        product = productsService.save(product);
        return productConverter.entityToDto(product);
        //return productMapper.MAPPER.fromProduct(product);
    }
    @PostMapping
    public OrderDto saveNewOrder(@RequestBody OrderDto orderDto) {
        orderValidator.validate(orderDto);
        Order order = orderMapper
    }
}
