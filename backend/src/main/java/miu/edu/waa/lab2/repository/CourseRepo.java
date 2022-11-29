package miu.edu.waa.lab2.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.NoArgsConstructor;
import miu.edu.waa.lab2.model.Course;

@Repository
@NoArgsConstructor
public class CourseRepo {

    static List<Course> courses = new ArrayList<>();

    static {
        courses.add(new Course(1, "WAA", "CS545"));
        courses.add(new Course(1, "EA", "CS544"));
        courses.add(new Course(1, "SA", "CS590"));
    }

    public boolean addCourse(Course newCourse) {
        try {
            courses.add(newCourse);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourseById(int id) {
        return courses.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return StudentRepo.students
                .stream()
                .filter(s -> s.getId() == studentId)
                .flatMap(s -> s.getCoursesTaken().stream())
                .toList();
    }

    public Course updateCourse(int id, Course newCourse) {
        Integer indexOfCourse = courses
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .map(c -> c.getId())
                .orElse(-1);

        return courses.set(indexOfCourse, newCourse);
    }

    public boolean removeCourse(int id) {
        return courses.removeIf(c -> c.getId() == id);
    }

}
