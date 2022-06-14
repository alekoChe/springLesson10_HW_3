package ru.gbAleko.springLesson10_HW_3.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gbAleko.springLesson10_HW_3.converters.OrderMapper;
import ru.gbAleko.springLesson10_HW_3.converters.ProductConverter;
import ru.gbAleko.springLesson10_HW_3.dto.OrderDto;
import ru.gbAleko.springLesson10_HW_3.dto.ProductDto;
import ru.gbAleko.springLesson10_HW_3.models.Cart;
import ru.gbAleko.springLesson10_HW_3.models.entities.Order;
import ru.gbAleko.springLesson10_HW_3.models.entities.Product;
import ru.gbAleko.springLesson10_HW_3.services.OrderService;
import ru.gbAleko.springLesson10_HW_3.services.ProductsService;
import ru.gbAleko.springLesson10_HW_3.validators.OrderValidator;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    @Autowired
    private Cart cart = new Cart();
    private final OrderValidator orderValidator;
    private final OrderMapper orderMapper;
    private final OrderService orderService;
    private final ProductsService productsService;
    private final ProductConverter productConverter;

    @DeleteMapping
    public void deleteById(@RequestParam Long idProduct) {
        Product product = productsService.findById(idProduct).orElseThrow();
        ProductDto productDto = productConverter.entityToDto(product);
        cart.deleteProductFromCartList(productDto);
    }

    @GetMapping
    public void addProduct(@RequestParam Long idProduct, @RequestParam Integer numberProducts) {
        Product product = productsService.findById(idProduct).orElseThrow();
        ProductDto productDto = productConverter.entityToDto(product);
        cart.addProductIntoCart(productDto, numberProducts);
    }


    @PostMapping
    public OrderDto saveNewOrder(@RequestBody OrderDto orderDto) {
        orderValidator.validate(orderDto);
        Order order = orderMapper.MAPPER.toOrder(orderDto);
        order = orderService.save(order);
        return orderMapper.MAPPER.fromOrder(order);
    }
}
