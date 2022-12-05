package edu.miu.w1d2.repository;

import edu.miu.w1d2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {
    static List<Course> courses = new ArrayList<>();

    static {
        courses.add(new Course(1, "WAP", "CS560",false));
        courses.add(new Course(2, "WAA", "CS599",false));
        courses.add(new Course(3, "ALG", "CS440",false));
    }
    public void save(Course c){
        courses.add(c);
    }

    public Course getCourseById(int id){
        return  courses.stream()
                .filter(x->x.getId()==id)
                .filter(x->!x.isDelete())
                .findFirst().get();
    }


    public void updateCourse(Course c,int id ){
        Course courseById = getCourseById(id);
        courseById.setCode(c.getCode());
        courseById.setId(c.getId());
        courseById.setName(c.getName());
    }

    public List<Course> getAllCourse(){
        return courses.stream()
                .filter(x->!x.isDelete())
                .collect(Collectors.toList());
    }

    public void delete(int id){
        getCourseById(id).setDelete(true);
    }

}
