package lab.waa.rest.service;

import lab.waa.rest.entity.Course;
import lab.waa.rest.entity.Student;

import java.util.List;

public interface CourseService {
    List<Course> getCourses(int offset, int count);
    Course getById(int id);
    void deleteById(int id);
    void updateById(int id, Course course);
    void save (Course course);
}
