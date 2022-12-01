package edu.miu.w1d2rest.service.impl;

import edu.miu.w1d2rest.dto.CourseDto;
import edu.miu.w1d2rest.entity.Course;
import edu.miu.w1d2rest.repository.CourseRepo;
import edu.miu.w1d2rest.repository.StudentRepo;
import edu.miu.w1d2rest.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<CourseDto> getAll() {
        List<Course> courses = courseRepo.getAll();
        List<CourseDto> list = courses.stream()
                .map(course -> modelMapper.map(course, CourseDto.class))
                .collect(Collectors.toList());

        return list;
    }

    @Override
    public void save(CourseDto product) {
        var entity = modelMapper.map(product, Course.class);
        courseRepo.save(entity);
    }

    @Override
    public void update(int id, CourseDto product) {
        var entity = modelMapper.map(product, Course.class);
        courseRepo.update(id, entity);
    }

    @Override
    public void delete(int id) {
        courseRepo.deleteById(id);

        //also delete course in the student
        studentRepo.deleteCourseOfStudent(id);
    }

    @Override
    public CourseDto getById(int id) {
        Course entity = courseRepo.getById(id);
        return modelMapper.map(entity, CourseDto.class);
    }
}
