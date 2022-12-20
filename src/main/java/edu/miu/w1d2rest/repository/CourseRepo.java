package edu.miu.w1d2rest.repository;

import edu.miu.w1d2rest.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    static List<Course> courseList = new ArrayList<>();
    static {
        courseList.add(new Course(1001, "MPP", "CS401"));
        courseList.add(new Course(1002, "WAP", "CS472"));
        courseList.add(new Course(1003, "MWA", "CS572"));
    }

    public List<Course> getAll() {
        return courseList.stream()
                .filter(course -> !course.isDeleted())
                .toList();
    }

    public Course getById(int id) {
        return courseList.stream()
                .filter(course -> course.getId() == id && !course.isDeleted())
                .findFirst()
                .get();
    }

    public void save(Course course){
        courseList.add(course);
    }

    public void update(int id, Course course){
        //find index using id first
        int index = courseList.indexOf(getById(id));
        courseList.set(index, course);
    }

    public void deleteById(int id){
        courseList.stream()
                .filter(course -> course.getId() == id)
                .findFirst()
                .get().setDeleted(true);

    }
}
