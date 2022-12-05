package edu.miu.lab2.service.impl;

import edu.miu.lab2.entity.Course;
import edu.miu.lab2.repository.CourseRepo;
import edu.miu.lab2.repository.StudentRepo;
import edu.miu.lab2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    private final StudentRepo studentRepo;

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
          return studentRepo.getAll().stream()
                .filter(e -> e.getId() == studentId)
                .map(e -> e.getCourses())
                .findFirst()
                .get();
    }

    @Override
    public Course findById(int id) {
        return courseRepo.findById(id);
    }

    @Override
    public List<Course> getAll() {
        return courseRepo.getAll();
    }

    @Override
    public boolean add(Course c) {
        return courseRepo.add(c);
    }

    @Override
    public boolean update(int id, Course c) {
        return courseRepo.update(id, c);
    }

    @Override
    public boolean delete(int id) {
        return courseRepo.delete(id);
    }
}
