package edu.miu.restdemo.controller;

import edu.miu.restdemo.dto.ProductDto;
import edu.miu.restdemo.entity.Product;
import edu.miu.restdemo.entity.Review;
import edu.miu.restdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {


    @Autowired
    private ProductService productService;



    @GetMapping
    public List<ProductDto> getAll(){
        System.out.println("get all is running");
        return null;
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable int id){
        System.out.println("get by id is running");
        return productService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody ProductDto product){
        System.out.println("create is running");
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        System.out.println("delete is running");
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ProductDto product){
        System.out.println("update is running");
    }

}
