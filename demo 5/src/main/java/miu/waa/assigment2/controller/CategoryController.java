package miu.waa.assigment2.controller;


import miu.waa.assigment2.entity.Category;
import miu.waa.assigment2.entity.Product;
import miu.waa.assigment2.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping
    public void save(@RequestBody Category c) {
        categoryService.save(c);
    }
}
