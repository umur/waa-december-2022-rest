package com.example.labtwo.service.Impl;

import com.example.labtwo.entity.Course;
import com.example.labtwo.repository.CourseRepo;
import com.example.labtwo.repository.StudentRepo;
import com.example.labtwo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo cRepo;
    private final StudentRepo sRepo;


    @Override
    public void add(Course course) {


    }

    @Override
    public List<Course> getCourseById(int id) {
        return sRepo.getAll().stream()
                .filter(item->item.getId() == id)
                .map(x->x.getCoursesTaken())
                .findFirst().get();
    }

    @Override
    public void update(int id, Course course) {
        cRepo.updateCourse(id, course);

    }

    @Override
    public void delete(int id) {
        cRepo.deleteCourse(id);

    }
}
