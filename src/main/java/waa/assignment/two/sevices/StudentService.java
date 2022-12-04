package waa.assignment.two.sevices;

import java.util.List;

import org.springframework.stereotype.Service;

import waa.assignment.two.dto.StudentDto;
import waa.assignment.two.model.Course;


@Service
public interface StudentService {
    StudentDto getById(int id);

    void save(StudentDto studentDto);
    void update(int id,StudentDto studentDto);

    List<StudentDto> getAll();

    void delete(int id);
    List<StudentDto> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int id);

}
