package com.example.labtwo.service.Impl;

import com.example.labtwo.dto.CourseDto;
import com.example.labtwo.dto.StudentDto;
import com.example.labtwo.repository.CourseRepo;
import com.example.labtwo.repository.StudentRepo;
import com.example.labtwo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {


    private final CourseRepo cRepo;
    private final StudentRepo sRepo;

    @Override
    public void add(StudentDto student) {

    }

    @Override
    public StudentDto getById(int id) {

        return null;
    }

    @Override
    public void update(int id, StudentDto student) {

    }


    @Override
    public void delete(int id) {

    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        return null;
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int id) {
        return null;
    }

}
