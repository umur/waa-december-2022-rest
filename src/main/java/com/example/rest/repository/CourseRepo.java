package com.example.rest.repository;

import com.example.rest.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {

    public static List<Course> courses = new ArrayList<>();
    public static Course c1;
    public static Course c2;
    public static Course c3;

    static {
        c1 = new Course(1,"Math","A001");
        c2 = new Course(2,"Science","A002");
        c3 = new Course(3,"English","A003");

        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
    }

    public List<Course> getAllCourses()
    {
        return courses;
    }

    public void add(Course course) {
        courses.add(course);
    }

    public void update(Course course, int id) {
        if (course != null) {
            Course item = findById(id);
            if (item != null) {
                courses.set(courses.indexOf(item), course);
            }
        }
    }

    public void Delete(int id) {
        Course item = findById(id);
        if (item != null) {
            courses.remove(courses.indexOf(item));
        }
    }
    private Course findById(int id)
    {
        return courses.stream().filter(x->x.getId()== id).findFirst().get();
    }
}
