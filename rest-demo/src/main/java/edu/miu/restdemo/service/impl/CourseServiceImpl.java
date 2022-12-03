package edu.miu.restdemo.service.impl;

import edu.miu.restdemo.dto.CourseDto;
import edu.miu.restdemo.entity.Course;
import edu.miu.restdemo.repository.CourseRepo;
import edu.miu.restdemo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    @Override
    public CourseDto getById(int id) {
        // validation
        // authorization
        // logging
        CourseDto dto = new CourseDto();
        return dto.toDto(courseRepo.getById(id));
    }

    @Override
    public void save(CourseDto p) {
        // validate
        CourseDto dto = new CourseDto();
        courseRepo.save(dto.toEntity(p));
    }

    @Override
    public List<CourseDto> getAllCourses() {
        CourseDto dto = new CourseDto();
        List<Course> tempList = courseRepo.getAllCourses();
        List<CourseDto> result = tempList.stream()
                .map(c -> dto.toDto(c))
                .collect(Collectors.toList());
        return result;

    }

    @Override
    public void update(int id, CourseDto c){
        CourseDto dto = new CourseDto();
        courseRepo.update(id, dto.toEntity(c));
    }

    @Override
    public void delete(int id){
        courseRepo.delete(id);
    }
}
