package ru.gbAleko.springLesson10_HW_3.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gbAleko.springLesson10_HW_3.converters.OrderMapper;
import ru.gbAleko.springLesson10_HW_3.dto.OrderDto;
import ru.gbAleko.springLesson10_HW_3.dto.ProductDto;
import ru.gbAleko.springLesson10_HW_3.models.Cart;
import ru.gbAleko.springLesson10_HW_3.models.entities.Order;
import ru.gbAleko.springLesson10_HW_3.services.OrderService;
import ru.gbAleko.springLesson10_HW_3.validators.OrderValidator;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    //private final CartService cartService;
    @Autowired
    private Cart cart = new Cart();
    private final OrderValidator orderValidator;
    private final OrderMapper orderMapper;
    private final OrderService orderService;

    @DeleteMapping("/delete")
    public void deleteById(@RequestBody ProductDto productDto) {
        cart.deleteProductFromCartList(productDto);
    }


    @GetMapping("/add")
    public void addProduct(@RequestBody ProductDto productDto, @RequestParam Integer numberProducts) {
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
