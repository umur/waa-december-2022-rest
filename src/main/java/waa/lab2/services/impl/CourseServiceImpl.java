package waa.lab2.services.impl;

import waa.lab2.entity.Course;
import waa.lab2.repository.CourseRepo;
import waa.lab2.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public List<Course> getAll() {
        return courseRepo.getAll();
    }

    @Override
    public void save(Course course) {
        courseRepo.save(course);
    }

    @Override
    public Course getById(int id) {
        return courseRepo.getById(id);
    }

    @Override
    public void update(int id, Course course) {
        courseRepo.update(id, course);
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }
}
