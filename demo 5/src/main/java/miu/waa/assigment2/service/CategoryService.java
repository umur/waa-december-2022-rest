package miu.waa.assigment2.service;

import miu.ea.assigment3.entity.Category;
import miu.ea.assigment3.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    void save(Category c);
}
