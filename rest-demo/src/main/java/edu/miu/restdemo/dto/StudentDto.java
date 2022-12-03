package edu.miu.restdemo.dto;

import edu.miu.restdemo.entity.Course;
import edu.miu.restdemo.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDto {

    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private String major;

    private List<Course> coursesTaken;


    public Student toEntity(StudentDto dto){
//        Course c = new Course();
        Student s = new Student();
        s.setId(dto.getId());
        s.setFirstName(dto.getFirstName());
        s.setLastName(dto.getLastName());
        s.setMajor(dto.getMajor());
        s.setEmail(dto.getEmail());
        s.setCoursesTaken(dto.coursesTaken);
        return s;
    }

    public StudentDto toDto(Student s){
        StudentDto dto = new StudentDto();
        dto.setId(s.getId());
        dto.setFirstName(s.getFirstName());
        dto.setLastName(s.getLastName());
        dto.setEmail(s.getEmail());
        dto.setMajor(s.getMajor());
        dto.setCoursesTaken(s.getCoursesTaken());
        return dto;
    }

}
