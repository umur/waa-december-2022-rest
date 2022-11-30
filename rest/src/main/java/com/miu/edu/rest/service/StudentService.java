package com.miu.edu.rest.service;

import com.miu.edu.rest.entity.Course;
import com.miu.edu.rest.entity.Student;


import java.util.List;

public interface StudentService {

    List<Student> getAll();

//    List<Student2> getAll2();

    List<Course> getCoursesByStudentId(int id);

    List<Student> getStudentByMajor(String major);

    void save(Student s);

//    void save2(Student2 s);
    void update(Student s, int id);

    void delete(int id);

    Student getById(int id);

}
