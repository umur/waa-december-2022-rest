package com.example.labtwo.service.Impl;

import com.example.labtwo.dto.CourseDto;
import com.example.labtwo.repository.CourseRepo;
import com.example.labtwo.repository.StudentRepo;
import com.example.labtwo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo cRepo;
    private final StudentRepo sRepo;



    @Override
    public void add(CourseDto course) {

    }

    @Override
    public CourseDto getCourseById(int id) {

        return null;
    }

    @Override
    public void update(int id, CourseDto course) {

    }

    @Override
    public void delete(int id) {
        cRepo.deleteCourse(id);

    }
}
