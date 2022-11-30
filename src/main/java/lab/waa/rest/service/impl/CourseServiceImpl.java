package lab.waa.rest.service.impl;

import lab.waa.rest.entity.Course;
import lab.waa.rest.repository.CourseRepo;
import lab.waa.rest.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;


    @Override
    public List<Course> getCourses(int offset, int count) {
        return courseRepo.getCourses(offset, count);
    }

    @Override
    public Course getById(int id) {
        return courseRepo.getById(id);
    }

    @Override
    public void deleteById(int id) {
        courseRepo.deleteById(id);
    }

    @Override
    public void updateById(int id, Course course) {
        courseRepo.updateById(id, course);
    }

    @Override
    public void save(Course course) {
        courseRepo.save(course);
    }
}
