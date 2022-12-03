package edu.miu.restdemo.repository;

import edu.miu.restdemo.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo{

    static List<Course> courses = new ArrayList<>();

    static {
        courses.add(new Course(1, "MPP", "CS401"));
        courses.add(new Course(2, "WAP", "CS472"));
        courses.add(new Course(3, "MWA", "CS572"));
        courses.add(new Course(4, "WAA", "CS545"));
    }

    public void save(Course c) {
        courses.add(c);
    }

    public Course getById(int id) {
        return courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst().get();
    }

    public List<Course> getAllCourses(){
        return courses;
    }


    public boolean delete(int id) {
       return courses.removeIf(p -> p.getId() == id);
    }

    public void update(int id, Course c) {
        delete(id);
        save(c);
    }

}
