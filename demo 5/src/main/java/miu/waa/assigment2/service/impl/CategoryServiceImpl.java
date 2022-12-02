package miu.waa.assigment2.service.impl;

import miu.ea.assigment3.entity.Category;
import miu.ea.assigment3.entity.Product;
import miu.ea.assigment3.repository.CategoryRepo;
import miu.ea.assigment3.repository.ProductRepo;
import miu.ea.assigment3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ProductRepo productRepo;
    @Override
    public void save(Category c) {
        categoryRepo.save(c);

    }
}
