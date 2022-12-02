package edu.miu.restdemo.service.impl;

import edu.miu.restdemo.dto.ProductDto;
import edu.miu.restdemo.entity.Product;
import edu.miu.restdemo.repository.ProductRepo;
import edu.miu.restdemo.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public ProductDto getById(int id) {
        // validation
        // authorization
        // logging
        ProductDto dto = new ProductDto();
        return dto.toDto(productRepo.getById(id));
    }

    @Override
    public void save(ProductDto p) {
        // validate
        ProductDto dto = new ProductDto();
        productRepo.save(dto.toEntity(p));
    }
}
