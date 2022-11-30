package edu.miu.lab2.service;

import edu.miu.lab2.model.Course;
import edu.miu.lab2.model.dto.CourseDTO;
import edu.miu.lab2.repository.CourseRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepo courseRepo;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CourseDTO> getAllProducts() {
        List<Course> courses = courseRepo.findAllCourses();

        List<CourseDTO> coursesDTO = new ArrayList<>();

        //map
        for (Course course: courses) {
            coursesDTO.add(modelMapper.map(course, CourseDTO.class));
        }

        return coursesDTO;
    }

    @Override
    public void addCourse(CourseDTO courseDTO) {
        Course course = modelMapper.map(courseDTO, Course.class);
        courseRepo.addCourse(course);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepo.deleteCourse(id);
    }

    @Override
    public void updateCourse(int id, CourseDTO courseDTO) {
        Course course = modelMapper.map(courseDTO, Course.class);
        courseRepo.updateCourse(id, course);
    }
}
