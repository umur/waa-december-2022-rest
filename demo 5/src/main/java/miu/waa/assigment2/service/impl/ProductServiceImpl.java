package miu.waa.assigment2.service.impl;


import miu.ea.assigment3.entity.DTOs.ProductDto;
import miu.ea.assigment3.entity.Product;
import miu.ea.assigment3.repository.ProductRepo;
import miu.ea.assigment3.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProductDto save(ProductDto p) {
        Product product=modelMapper.map(p,Product.class);
        Product pro=productRepo.save(product);
        return modelMapper.map(pro,ProductDto.class);
    }

    @Override
    public ProductDto delete(int id) {
        Product product=productRepo.findById(id);
       productRepo.delete(product);
        return modelMapper.map(product,ProductDto.class);

    }

    @Override
    public ProductDto getById(int id) {

        return modelMapper.map(productRepo.findById(id),ProductDto.class);
    }

    @Override
    public List<ProductDto> getAll() {
        return productRepo.findAll().stream().map(p->modelMapper.map(p,ProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findByPriceGreaterThan(float price) {

        return productRepo.findByPriceGreaterThan(price).stream().map(product -> modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findAllByNameContaining(String keyword) {
        return productRepo.findAllByNameContaining(keyword).stream().map(product -> modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
    }

//    @Override
//    public void save(Product p) {
//        productRepo.save(p);
//    }

//    @Override
//    public void delete(int id) {
//        productRepo.delete(id);
//    }

//    @Override
//    public Product getById(int id) {
//        return productRepo.findById(id);
//    }
//
//    @Override
//    public List<Product> getAll() {
//        return productRepo.findAll();
//    }
//
//    @Override
//    public List<Product> findByPriceGreaterThan(float price) {
//        return productRepo.findByPriceGreaterThan(price);
//    }
//
//    @Override
//    public List<Product> findAllByNameContaining(String keyword) {
//        return productRepo.findAllByNameContaining(keyword).stream().collect(Collectors.toList());
//    }

}
