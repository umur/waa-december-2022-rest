package miu.edu.waa.lab2.service;

import java.util.List;
import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import miu.edu.waa.lab2.model.Course;
import miu.edu.waa.lab2.model.dto.CourseDTO;
import miu.edu.waa.lab2.repository.CourseRepo;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;
    private final Function<Course, CourseDTO> mapToDTO = course -> mapToCourseDTO(course);

    private CourseDTO mapToCourseDTO(Course course) {
        return modelMapper.map(course, CourseDTO.class);
    }

    private Course mapToCourseFromDTO(CourseDTO courseDTO) {
        return modelMapper.map(courseDTO, Course.class);
    }

    @Override
    public boolean addCourse(CourseDTO courseDTO) {
        Course course = modelMapper.map(courseDTO, Course.class);
        return courseRepo.addCourse(course);
    }

    @Override
    public boolean deleteCourse(int id) {
        return courseRepo.removeCourse(id);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> allCourses = courseRepo.getAllCourses();

        return allCourses
                .stream()
                .map(mapToDTO)
                .toList();
    }

    @Override
    public CourseDTO getCourseById(int id) {
        Course course = courseRepo.getCourseById(id);
        return mapToCourseDTO(course);
    }

    @Override
    public List<CourseDTO> getCoursesByStudentId(int studentId) {
        List<Course> coursesByStudentId = courseRepo.getCoursesByStudentId(studentId);

        return coursesByStudentId
                .stream()
                .map(mapToDTO)
                .toList();
    }

    @Override
    public CourseDTO updateCourse(int id, CourseDTO courseDTO) {
        Course updatedCourse = courseRepo.updateCourse(id, mapToCourseFromDTO(courseDTO));
        return mapToCourseDTO(updatedCourse);
    }

}
