package miu.waa.assigment2.repository;

import miu.ea.assigment3.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends CrudRepository<Review,Integer> {

    List<Review> findAll();
    Review findById(int id);

    Review deleteById(int id);

}
