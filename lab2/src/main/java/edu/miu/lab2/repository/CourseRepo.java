package edu.miu.lab2.repository;

import edu.miu.lab2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    List<Course> courses = new ArrayList<>();

    public Course findById(int id) {
        return courses.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .get();
    }

    public List<Course> getAll() {
        return courses;
    }

    public boolean add(Course course) {
        try {
            courses.add(course);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(int id, Course s) {
        try {
            Course courseToUpdate = findById(id);

            int index = courses.indexOf(courseToUpdate);
            courses.set(index, s);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            Course courseToDelete = findById(id);

            int index = courses.indexOf(courseToDelete);
            courses.remove(index);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
