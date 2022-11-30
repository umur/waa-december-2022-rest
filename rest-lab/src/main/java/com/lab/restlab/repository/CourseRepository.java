package com.lab.restlab.repository;

import com.lab.restlab.entity.Course;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository
{
    //create read update delete

    //list as a proxy database table
    private static List<Course> courseList = new ArrayList<>();
    static {
        courseList.add(new Course(1, "FPP", "C101"));
        courseList.add(new Course(2, "MPP", "C201"));
        courseList.add(new Course(2, "WAP", "C202"));
        courseList.add(new Course(2, "WAA", "C301"));
    }

    public List<Course> getAll(){
        return courseList;
    }

    public Course getById(int id) {
        return courseList.stream().filter(c -> c.getId() == id).findAny().get();
    }

    public void save(Course course) {
        courseList.add(course);
    }

    public Course update(int id, Course course) {
        for(int i = 0; i < courseList.size(); i++){
            if(courseList.get(i).getId() == id){
                courseList.set(i, course);
            }
        }
        return course;
    }

    public void delete(int id) {
        courseList = courseList.stream().filter(p -> p.getId() != id).toList();
    }

}
