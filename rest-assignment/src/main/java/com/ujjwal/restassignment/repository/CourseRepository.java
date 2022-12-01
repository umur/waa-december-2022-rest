package com.ujjwal.restassignment.repository;

import com.ujjwal.restassignment.dto.CourseDto;
import com.ujjwal.restassignment.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {
    //    creating arraylist for storing the data
    private static List<Course> courseList = new ArrayList<>();

    //    initializing the course list with values
    static {
        courseList.add(new Course(1, "FPP", "CS390"));
        courseList.add(new Course(2, "MPP", "CS401"));
        courseList.add(new Course(3, "MAP", "CS445"));
        courseList.add(new Course(4, "WAA", "CS545"));
        courseList.add(new Course(5, "EA", "CS544"));
    }

    //    get all courses
    public List<Course> getAll() {
        return courseList;
    }

    //    get course by id
    public Course getById(int id) {
        Optional<Course> c = courseList.stream().filter(course -> course.getId() == id).findFirst();
        return c.orElse(null);
    }
    //    adding a new course
    public void save(Course course){
        courseList.add(course);
    }
    //    update a course
    public Course update(int id, Course course){
        for (Course course1 : courseList){
            if (course1.getId() == id){
                courseList.set(id,course);
            }
        }
        return course;
    }
    //    delete a course
    public void delete(int id){
        courseList.removeIf(course -> course.getId()==id);
    }

}

