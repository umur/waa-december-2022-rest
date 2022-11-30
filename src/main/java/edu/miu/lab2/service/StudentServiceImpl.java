package edu.miu.lab2.service;

import edu.miu.lab2.model.Course;
import edu.miu.lab2.model.Student;
import edu.miu.lab2.model.dto.CourseDTO;
import edu.miu.lab2.model.dto.StudentDTO;
import edu.miu.lab2.repository.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    public StudentRepo studentRepo;

    private ModelMapper modelMapper = new ModelMapper();


    @Override
    public List<StudentDTO> findAllStudents() {
        List<Student> students = studentRepo.findAllStudents();

        List<StudentDTO> studentDTOS = new ArrayList<>();

        //map
        for (Student student: students) {
            studentDTOS.add(modelMapper.map(student, StudentDTO.class));
        }
        return studentDTOS;
    }

    @Override
    public void addStudent(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        studentRepo.addStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepo.deleteStudent(id);
    }

    @Override
    public void updateStudent(int id, StudentDTO studentDTO) {
       Student student = modelMapper.map(studentDTO, Student.class);
       studentRepo.updateStudent(id, student);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }
}
