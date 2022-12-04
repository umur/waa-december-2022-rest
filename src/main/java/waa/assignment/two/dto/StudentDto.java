package waa.assignment.two.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import waa.assignment.two.model.Course;
import waa.assignment.two.model.Student;

@Getter
@Setter
public class StudentDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;

    public StudentDto toDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setMajor(student.getMajor());
        studentDto.setCoursesTaken(student.getCoursesTaken());
        return studentDto;
    }

    public Student toStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setMajor(studentDto.getMajor());
        student.setCoursesTaken(studentDto.getCoursesTaken());
        return student;
    }

}
