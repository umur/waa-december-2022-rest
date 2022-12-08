package MIU.edu.studentsrestapi.services.impl;

import MIU.edu.studentsrestapi.dtos.CourseDto;
import MIU.edu.studentsrestapi.entities.Course;
import MIU.edu.studentsrestapi.repositories.CourseRepository;
import MIU.edu.studentsrestapi.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseDto> getCourses() {
        return courseRepository.getCourses();
    }

    @Override
    public CourseDto getCourse(int courseId) {
        return courseRepository.getCourse(courseId);
    }

    @Override
    public String deleteCourse(int courseId) {
        return courseRepository.deleteCourse(courseId);
    }

    @Override
    public String addCourse(CourseDto courseDto) {
        return courseRepository.addCourse(courseDto);
    }

    @Override
    public String updateCourse(int courseId, CourseDto courseDto) {
        return courseRepository.updateCourse(courseId, courseDto);
    }


}
