package MIU.edu.studentsrestapi.services.impl;

import MIU.edu.studentsrestapi.dtos.CourseDto;
import MIU.edu.studentsrestapi.dtos.StudentDto;
import MIU.edu.studentsrestapi.repositories.StudentRepository;
import MIU.edu.studentsrestapi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    }

    @Override
    public List<StudentDto> getStudents() {
        return studentRepository.getStudents();
    }

    @Override
    public String addStudent(StudentDto studentDto) {
        return studentRepository.addStudent(studentDto);
    }

    @Override
    public StudentDto getStudent(int studentId) {
        return studentRepository.getStudent(studentId);
    }

    @Override
    public String deleteStudent(int studentId) {
        return studentRepository.deleteStudent(studentId);
    }

    @Override
    public String updateStudent(int studentId, StudentDto studentDto) {
        return studentRepository.updateStudent(studentId, studentDto);
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        return studentRepository.getCoursesByStudentId(studentId);
    }
}
