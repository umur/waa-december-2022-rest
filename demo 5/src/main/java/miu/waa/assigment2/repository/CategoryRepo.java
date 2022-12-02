package miu.waa.assigment2.repository;

import miu.ea.assigment3.entity.Category;
import miu.ea.assigment3.service.CategoryService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {

}
