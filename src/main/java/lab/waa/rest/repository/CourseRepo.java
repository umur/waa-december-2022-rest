package lab.waa.rest.repository;

import lab.waa.rest.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    static List<Course> courses = new ArrayList<>();

    static {
        courses.add(new Course(1, "MPP", "CS401"));
        courses.add(new Course(2, "WAA", "CS545"));
        courses.add(new Course(3, "MWA", "CS572"));
        courses.add(new Course(4, "WAP", "CS472"));
        courses.add(new Course(5, "ALGO", "CS477"));
        courses.add(new Course(6, "EA", "CS506"));
    }


    public List<Course> getCourses(int offset, int count) {
        return courses.stream()
                .skip(offset)
                .limit(count).toList();
    }

    public Course getById(int id) {
        return courses.stream()
                .filter(s -> s.getId() == id)
                .findFirst().get();
    }

    public void deleteById(int id) {
        courses.removeIf(s -> s.getId() == id);
    }

    public void updateById(int id, Course course){
        courses.stream()
                .filter(s->s.getId()==id)
                .findFirst()
                .ifPresent(s->{
                    if(course.getName()!=null)s.setName(course.getName());
                    if(course.getCode()!=null)s.setCode(course.getCode());
                });
    }

    public void save(Course course) {
        courses.add(course);
    }


}
