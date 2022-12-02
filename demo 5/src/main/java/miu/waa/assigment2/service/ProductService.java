package miu.waa.assigment2.service;



import miu.ea.assigment3.entity.DTOs.ProductDto;
import miu.ea.assigment3.entity.Product;
import miu.ea.assigment3.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
//    void save(Product p);
//    //void save(ProductDto p);
//
////    void delete(int id);
//
//    Product getById(int id);
//
//    List<Product> getAll();
//
//    List<Product> findByPriceGreaterThan(float price);
//
//    List<Product> findAllByNameContaining(String keyword);
    ProductDto save(ProductDto p);
    //void save(ProductDto p);

    ProductDto delete(int id);

    ProductDto getById(int id);

    List<ProductDto> getAll();

    List<ProductDto> findByPriceGreaterThan(float price);

    List<ProductDto> findAllByNameContaining(String keyword);


}
