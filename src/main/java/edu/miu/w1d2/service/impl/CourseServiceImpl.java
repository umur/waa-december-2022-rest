package edu.miu.w1d2.service.impl;

import edu.miu.w1d2.dto.CourseDto;
import edu.miu.w1d2.entity.Course;
import edu.miu.w1d2.repository.CourseRepository;
import edu.miu.w1d2.repository.StudentRepository;
import edu.miu.w1d2.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CourseDto> getAll() {
        List<Course> allCourse = courseRepository.getAllCourse();
        System.out.println(allCourse);
        return  allCourse.stream()
                .map(x->modelMapper.map(x,CourseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto getById(int id) {
        Course courseById = courseRepository.getCourseById(id);
        return modelMapper.map(courseById,CourseDto.class);
    }

    @Override
    public void create(CourseDto c) {
        courseRepository.save(modelMapper.map(c,Course.class));
    }

    @Override
    public void delete(int id) {
        courseRepository.delete(id);
    }

    @Override
    public void update(CourseDto ct,int id) {
        courseRepository.updateCourse(modelMapper.map(ct,Course.class),id);
    }



    @Override
    public List<CourseDto> getAllCourseOfStudents() {
        return  studentRepository.getAllStudent().stream()
                .flatMap(x -> x.getCoursesTaken().stream()
                        .map(y -> modelMapper.map(x, CourseDto.class)))
                .collect(Collectors.toList());
    }


}
