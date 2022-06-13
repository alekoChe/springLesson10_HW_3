package ru.gbAleko.springLesson10_HW_3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gbAleko.springLesson10_HW_3.dto.BuyerDto;
import ru.gbAleko.springLesson10_HW_3.dto.ProductDto;
import ru.gbAleko.springLesson10_HW_3.exceptions.ResourceNotFoundException;
import ru.gbAleko.springLesson10_HW_3.models.entities.Buyer;
import ru.gbAleko.springLesson10_HW_3.models.entities.Product;
import ru.gbAleko.springLesson10_HW_3.repositories.BuyerRepository;
import ru.gbAleko.springLesson10_HW_3.repositories.specifications.BuyerSpecifications;
import ru.gbAleko.springLesson10_HW_3.repositories.specifications.ProductsSpecifications;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuyerService {

    private final BuyerRepository buyerRepository;

    public Page<Buyer> findAll(String partName, Integer page) {
        Specification<Buyer> spec = Specification.where(null);

        if (partName != null) {
            spec = spec.and(BuyerSpecifications.nameLike(partName));
        }

        return buyerRepository.findAll(spec, PageRequest.of(page -1, 10));
    }

    public Optional<Buyer> findById(Long id) {
        return buyerRepository.findById(id);
    }

    public void deleteById(Long id) {
        buyerRepository.deleteById(id);
    }

    public Buyer save(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Transactional
    public Buyer update(BuyerDto buyerDto) {
        Buyer buyer = buyerRepository.findById(buyerDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Невозможно обновить клиента, не надйен в базе, id: " + buyerDto.getId()));
        buyer.setPhoneNumber(buyerDto.getPhoneNumber());
        return buyer;
    }
}
