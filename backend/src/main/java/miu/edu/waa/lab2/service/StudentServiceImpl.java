package miu.edu.waa.lab2.service;

import java.util.List;
import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import miu.edu.waa.lab2.model.Student;
import miu.edu.waa.lab2.model.dto.StudentDTO;
import miu.edu.waa.lab2.repository.StudentRepo;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;
    private final Function<Student, StudentDTO> mapToDTO = Student -> mapToStudentDTO(Student);

    private StudentDTO mapToStudentDTO(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }

    private Student mapToStudentFromDTO(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, Student.class);
    }

    @Override
    public boolean addStudent(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        return studentRepo.addStudent(student);
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentRepo.removeStudent(id);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> allStudents = studentRepo.getAllStudents();

        return allStudents
                .stream()
                .map(mapToDTO)
                .toList();
    }

    @Override
    public StudentDTO getStudentById(int id) {
        Student Student = studentRepo.getStudentById(id);
        return mapToStudentDTO(Student);
    }

    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {
        List<Student> students = studentRepo.getStudentsByMajor(major);

        return students
                .stream()
                .map(mapToDTO)
                .toList();
    }

    @Override
    public StudentDTO updateStudent(int id, StudentDTO studentDTO) {
        Student updatedStudent = studentRepo.updateStudent(id, mapToStudentFromDTO(studentDTO));
        return mapToStudentDTO(updatedStudent);
    }

}
