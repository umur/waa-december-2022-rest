package MIU.edu.studentsrestapi.services;

import MIU.edu.studentsrestapi.dtos.CourseDto;
import MIU.edu.studentsrestapi.entities.Course;

import java.util.List;

public interface CourseService {
    public List<CourseDto> getCourses();
    public CourseDto getCourse(int courseId);
    public String deleteCourse(int courseId);
    public String addCourse(CourseDto courseDto);
    public String updateCourse(int courseId, CourseDto courseDto);

}
