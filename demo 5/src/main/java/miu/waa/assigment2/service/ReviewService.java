package miu.waa.assigment2.service;

import miu.ea.assigment3.entity.Review;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    List<Review> findAll();
    Review findById(int id);

    Review deleteById(int id);
    public void save(Review r);


    public void delete();

    public void update();
    List<Review> findByProductId(int id);
}
