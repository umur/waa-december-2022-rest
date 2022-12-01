package com.example.labtwo.repository;

import com.example.labtwo.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    public static List<Course> courses = new ArrayList<>();


    static {
       Course c1 = new Course(1, "WAA", "cs547");
       Course c2 = new Course(2, "MWA", "cs447");
       Course c3 = new Course(3, "EA", "cs565");

        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
    }

    public void add (Course course){
        courses.add(course);
    }

    public List<Course> getCourses(){
        return courses.stream()
                .filter(course -> !course.isDeleted())
                .toList();
    }

    public void updateCourse( int id, Course course){
        if (course != null){
            Course crs = findById(id);
            if(crs != null){
                courses.set(courses.indexOf(crs), course);
            }
        }
    }

    public void deleteCourse(int id){
        courses.stream()
                .filter(course -> course.getId() == id)
                .findFirst()
                .get().setDeleted(true);

    }

    private Course findById(int id) {
       return courses.stream()
               .filter(course -> course.getId() == id)
               .findFirst().get();
    }


}
