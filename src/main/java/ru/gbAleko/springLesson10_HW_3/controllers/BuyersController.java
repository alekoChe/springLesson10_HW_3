package ru.gbAleko.springLesson10_HW_3.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.gbAleko.springLesson10_HW_3.converters.BuyerConverter;
import ru.gbAleko.springLesson10_HW_3.converters.BuyerMapper;
import ru.gbAleko.springLesson10_HW_3.dto.BuyerDto;
import ru.gbAleko.springLesson10_HW_3.dto.ProductDto;
import ru.gbAleko.springLesson10_HW_3.exceptions.ResourceNotFoundException;
import ru.gbAleko.springLesson10_HW_3.models.entities.Buyer;
import ru.gbAleko.springLesson10_HW_3.models.entities.Product;
import ru.gbAleko.springLesson10_HW_3.services.BuyerService;
import ru.gbAleko.springLesson10_HW_3.validators.BuyerValidator;

@RestController
@RequestMapping("/api/v1/buyers")
@RequiredArgsConstructor
public class BuyersController {

    private final BuyerService buyerService;
    private final BuyerConverter buyerConverter;
    private final BuyerValidator buyerValidator;
    private final BuyerMapper buyerMapper;

    @GetMapping
    public Page<BuyerDto> getAllBuyers(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "name_part", required = false) String namePart
    ) {
        if (page < 1) {
            page = 1;
        }
        return buyerService.findAll(namePart, page).map(
                b -> buyerMapper.MAPPER.fromBuyer(b)
        );
    }

    @GetMapping("/{id}")
    public BuyerDto getBuyerById(@PathVariable Long id) {
        Buyer buyer = buyerService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Buyer not found, id: " + id));
        return buyerMapper.MAPPER.fromBuyer(buyer);
    }

    @PostMapping
    public BuyerDto saveNewBuyer(@RequestBody BuyerDto buyerDto) {
        buyerValidator.validate(buyerDto);
        Buyer buyer = buyerMapper.toBuyer(buyerDto);
        buyer = buyerService.save(buyer);
        return buyerMapper.fromBuyer(buyer);
    }

    @PutMapping
    public BuyerDto updateBuyer(@RequestBody BuyerDto buyerDto) {
        buyerValidator.validate(buyerDto);
        Buyer buyer = buyerService.update(buyerDto);
        return buyerMapper.fromBuyer(buyer);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        buyerService.deleteById(id);
    }
}

