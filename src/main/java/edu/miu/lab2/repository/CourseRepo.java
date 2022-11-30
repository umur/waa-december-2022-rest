package edu.miu.lab2.repository;

import edu.miu.lab2.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    static List<Course> courseList = new ArrayList<>();
    static {
        courseList.add(new Course(1, "EA", "EA-544"));
        courseList.add(new Course(2, "WAA", "WAA-545"));
        courseList.add(new Course(3, "MWA", "MWA-590"));
    }

    public List<Course> findAllCourses(){
        return courseList;
    }
    public void addCourse(Course course){
        courseList.add(course);
    }
    public void deleteCourse(int id){
        Course courseDelete = null;
        for (Course course: courseList) {
            if (course.getId() == id){
                courseDelete = course;
            }
        }
        courseList.remove(courseDelete);
    }
    public void updateCourse(int id, Course course){
        Course courseUpdate = null;
        for (Course course1: courseList) {
            if (course1.getId() == id){
                courseUpdate = course1;
            }
        }
        courseList.set(courseList.indexOf(courseUpdate), course);
    }


}
