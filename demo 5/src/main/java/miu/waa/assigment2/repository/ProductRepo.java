package miu.waa.assigment2.repository;


import miu.ea.assigment3.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product,Integer> {
    List<Product> findAll();
    //void delete(int id);

    //void save(Product p);

    public Product findById(int id);



    List<Product> findByPriceGreaterThan(float price);

    List<Product> findAllByNameContaining(String keyword);
}
