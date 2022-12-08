package MIU.edu.studentsrestapi.services;

import MIU.edu.studentsrestapi.dtos.CourseDto;
import MIU.edu.studentsrestapi.dtos.StudentDto;

import java.util.List;

public interface StudentService {
    public List<StudentDto> getStudents();
    public String addStudent(StudentDto studentDto);
    public StudentDto getStudent(int studentId);
    public String deleteStudent(int studentId);
    public String updateStudent(int studentId, StudentDto studentDto);
    public List<StudentDto> getStudentsByMajor(String major);
    public List<CourseDto> getCoursesByStudentId(int studentId);
}
