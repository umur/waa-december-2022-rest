package waa.lab2.services;

import waa.lab2.entity.Course;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */

public interface CourseService {

    List<Course> getAll();
    void save(Course course);
    Course getById(int id);

    void update(int id, Course course);

    void delete(int id);
}
