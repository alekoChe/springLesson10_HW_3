package ru.gbAleko.springLesson10_HW_3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbAleko.springLesson10_HW_3.models.entities.Order;
import ru.gbAleko.springLesson10_HW_3.repositories.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
