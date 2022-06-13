package ru.gbAleko.springLesson10_HW_3.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.gbAleko.springLesson10_HW_3.models.entities.Buyer;
import ru.gbAleko.springLesson10_HW_3.models.entities.Product;

public class BuyerSpecifications {

    public static Specification<Buyer> nameLike(String namePart) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), String.format("%%%s%%", namePart)));
    }
}
