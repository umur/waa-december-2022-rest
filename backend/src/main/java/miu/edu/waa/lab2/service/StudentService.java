package miu.edu.waa.lab2.service;

import java.util.List;

import miu.edu.waa.lab2.model.dto.StudentDTO;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(int id);

    List<StudentDTO> getStudentsByMajor(String major);

    boolean addStudent(StudentDTO StudentDTO);

    StudentDTO updateStudent(int id, StudentDTO StudentDTO);

    boolean deleteStudent(int id);
}
