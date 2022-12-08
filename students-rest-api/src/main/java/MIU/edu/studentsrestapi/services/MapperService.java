package MIU.edu.studentsrestapi.services;

import MIU.edu.studentsrestapi.dtos.CourseDto;
import MIU.edu.studentsrestapi.dtos.StudentDto;
import MIU.edu.studentsrestapi.entities.Course;
import MIU.edu.studentsrestapi.entities.Student;

public interface MapperService {
    public Course courseDtoToCourse(CourseDto courseDto);
    public CourseDto courseToCourseDto(Course course);
    public StudentDto studentToStudentDto(Student student);
    public Student studentDtoToStudent(StudentDto student);
}
