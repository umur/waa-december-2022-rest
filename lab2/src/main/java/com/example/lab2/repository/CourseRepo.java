package com.example.lab2.repository;


import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    static List<Course> courses = new ArrayList<>();
   static {
       courses.add(new Course(101, "Modern Programming Practices", "MPP"));
       courses.add(new Course(102, "Fundamental of Programming Practices", "FPP"));
       courses.add(new Course(103, "Database", "DB"));
   }

    public void save(Course c){
        courses.add(c);
    }
    public List<Course> getAllCourses(){
        return courses;
    }
    public Course getCourseById(int id){
        return courses
                .stream()
                .filter(s->s.getId()==id)
                .findFirst().get();
    }

    public String deleteCourseById(int id){
        courses.remove(courses
                .stream()
                .filter(c->c.getId()==id)
                .findFirst().get());
        return "deleted";
    }
    public void updateCourse(int id, Course course){
        Course entry = getCourseById(id);
        entry.setId(course.getId());
        entry.setCode(course.getCode());
        entry.setName(course.getName());
        courses.add(entry);
    }


}
