package edu.miu.lab2.restdemo.repository;

import edu.miu.lab2.restdemo.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {

    private static List<Course> courses = new ArrayList<>();

    static {
       courses.add(new Course(1, "WAP", "CS472"));
       courses.add(new Course(2, "MDP", "CS475"));
       courses.add(new Course(3, "Algorithms", "CS435"));
       courses.add(new Course(4, "WAA", "CS545"));
    }

    public void save(Course c) {
        courses.add(c);
    }

    public List<Course> getCourses(){
        return courses;
    }

    public Course getId(int id) {
        return courses.stream()
                .filter(c -> c.getId() == id )
                .findFirst().get();
    }

    public void update (Course course, int id) {
        courses.forEach(c -> {
            if (c.getId() == id) {
                c = course;
            }
        });
    }

    public void delete(int id) {
        courses = courses.stream()
                .filter(c -> c.getId() != id)
                .collect(Collectors.toList());
    }

    public List<Course> findAll() {
        return courses;
    }

}
