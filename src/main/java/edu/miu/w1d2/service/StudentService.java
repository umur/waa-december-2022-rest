package edu.miu.w1d2.service;
import edu.miu.w1d2.dto.CourseDto;
import edu.miu.w1d2.dto.StudentDto;
import java.util.List;

public interface StudentService {
    List<StudentDto> getAll();
    StudentDto getById(int id);
    void create(StudentDto s);
    void delete(int id);
    void update(StudentDto sd, int id);
    List<StudentDto> getByMajor(String major);

    List<CourseDto> getCourseByStudentId(int studentId);
}
