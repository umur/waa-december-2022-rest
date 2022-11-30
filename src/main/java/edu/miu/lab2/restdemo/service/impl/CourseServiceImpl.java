package edu.miu.lab2.restdemo.service.impl;

import edu.miu.lab2.restdemo.dto.CourseDto;
import edu.miu.lab2.restdemo.entity.Course;
import edu.miu.lab2.restdemo.repository.CourseRepo;
import edu.miu.lab2.restdemo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

//    @Override
//    public List<CourseDto> getCourses() {
//        return courseRepo.getCourses().stream()
//                .map(c->);
//    }

    @Override
    public List<Course> getCourses() {
        return courseRepo.getCourses();
    }

    @Override
    public Course getId(int id) {
        return courseRepo.getId(id);
    }

    @Override
    public void update(Course c, int id) {
        courseRepo.update(c, id);
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }
}
