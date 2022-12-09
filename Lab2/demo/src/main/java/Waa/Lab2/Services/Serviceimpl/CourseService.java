package Waa.Lab2.Services.Serviceimpl;

import Waa.Lab2.Entity.Course;
import lombok.RequiredArgsConstructor;


import java.util.List;

import static Waa.Lab2.Repository.CourseRepo.courses;


public class CourseService {
    public List<Course> getAllCourses(){

        return courses;
    }
    public void add(Course newCourse){

        courses.add(newCourse);
    }

    public void delete(int id){
        Course item = getById(id);
        if (item != null) {
            courses.remove(courses.indexOf(item));
        }
    }
    private Course getById(int id)
    {
        return courses.stream().
                filter(x->x.getId()== id).findFirst().get();
    }
}

