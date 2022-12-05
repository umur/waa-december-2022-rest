package com.example.rest.servce.ServiceImpl;


import com.example.rest.entity.Course;
import com.example.rest.repository.CourseRepo;
import com.example.rest.repository.StudentRepo;
import com.example.rest.servce.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    StudentRepo studenRepo;
    CourseRepo courseRepo;

    @Autowired
    CourseServiceImpl(StudentRepo studentRepo, CourseRepo courseRepo)
    {
        this.studenRepo = studentRepo;
        this.courseRepo = courseRepo;
    }
    @Override
    public List<Course> GetCoursesByStudentId(int studentId) {
        return studenRepo
                .getAll()
                .stream()
                .filter(item->item.getId() == studentId)
                .map(item->item.getCourseTaken())
                .findFirst().get();
    }

    @Override
    public void Add(Course course) {
        courseRepo.add(course);
    }

    @Override
    public void Update(Course course, int id) {
        courseRepo.update(course,id);
    }

    @Override
    public void Delete(int id) {
        courseRepo.Delete(id);
    }

    @Override
    public List<Course> GetAll() {
        return courseRepo.getAllCourses();
    }

}
