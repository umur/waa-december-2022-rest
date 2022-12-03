package waa.lab2.repository;

import org.springframework.stereotype.Repository;
import waa.lab2.entity.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
@Repository
public class CourseRepo {
    static List<Course> courses = new ArrayList<>();

    static {
        courses.add(new Course(1, "WAA", "CS545"));
        courses.add(new Course(2, "MWA", "CS572"));
        courses.add(new Course(3, "WAP", "CS472"));
    }

    public void save(Course course) {
        courses.add(course);
    }

    public Course getById(int id) {
        return courses.stream().filter(c -> c.getId() == id).findFirst().get();
    }

    public List<Course> getAll() {
        return courses;
    }

    public boolean delete(int id) {
        return courses.removeIf(c -> c.getId() == id);
    }

    public void update(int id, Course course) {
        delete(id);
        save(course);
    }
}
