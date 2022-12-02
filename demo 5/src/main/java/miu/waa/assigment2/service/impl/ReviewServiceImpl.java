package miu.waa.assigment2.service.impl;

import miu.ea.assigment3.entity.Review;
import miu.ea.assigment3.repository.ReviewRepo;
import miu.ea.assigment3.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepo reviewRepo;

    @Override
    public List<Review> findAll() {
        return reviewRepo.findAll();
    }

    @Override
    public Review findById(int id) {
        return reviewRepo.findById(id);
    }

    @Override
    public Review deleteById(int id) {
        return reviewRepo.deleteById(id);
    }

    @Override
    public void save(Review r) {
        reviewRepo.save(r);
    }



    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public List<Review> findByProductId(int id) {
        return null;
    }
}
