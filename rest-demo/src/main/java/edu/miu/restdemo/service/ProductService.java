package edu.miu.restdemo.service;

import edu.miu.restdemo.dto.BasicProductDto;
import edu.miu.restdemo.dto.ProductDto;
import edu.miu.restdemo.entity.Product;

import java.util.List;

public interface ProductService {

    ProductDto getById(int id);

    void save(ProductDto p);

//    List<BasicProductDto> getBasicProducts();

}
