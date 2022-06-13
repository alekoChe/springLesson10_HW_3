package ru.gbAleko.springLesson10_HW_3.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gbAleko.springLesson10_HW_3.dto.ProductDto;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "buyer_id")
    private Buyer buyer;

    @Column(name = "orderList")
    private Map<ProductDto, Integer> orderList;
}
