package ru.gbAleko.springLesson10_HW_3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.gbAleko.springLesson10_HW_3.models.entities.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Long>, JpaSpecificationExecutor<Buyer> {
}
