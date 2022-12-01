package edu.miu.lab2.service.impl;

import edu.miu.lab2.entity.Course;
import edu.miu.lab2.repo.CourseRepo;
import edu.miu.lab2.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRep;

    public List<Course> getAllCourses(){
        return courseRep.getAllCourses();
    }

    public void addCourse(Course course){
        courseRep.save(course);
    }

    public Course getCourseById(int id){
        return courseRep.getByID(id);
    }

    public void deleteCourse(int id){
        courseRep.deleteCourse(id);
    }

}
