package edu.miu.lab2.repo;

import edu.miu.lab2.entity.Course;
import edu.miu.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {

    static List<Course> courseList = new ArrayList<>();
    static {
        courseList.add(new course(1, "FPP", "123"));
        courseList.add(new course(2, "MPP", "234"));
        courseList.add(new course(3, "WAP", "456"));
        courseList.add(new course(4, "WAA", "567"));
    }

    public void save (Course course){
        courseList.add(course);
    }

    public Course getByID(int id){
        return courseList.stream().filter(i -> i.getId() == id && !i.isDeleted()).findFirst().get();
    }

    public void deleteCourse(int id){
        courseList.stream().filter(i->i.getId() == id).findFirst().get().setDeleted(true);
    }

    public List<Course> getAllCourses(){
        return courseList;
    }
}
