package MIU.edu.studentsrestapi.services.impl;

import MIU.edu.studentsrestapi.dtos.CourseDto;
import MIU.edu.studentsrestapi.dtos.StudentDto;
import MIU.edu.studentsrestapi.entities.Course;
import MIU.edu.studentsrestapi.entities.Student;
import MIU.edu.studentsrestapi.services.MapperService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MapperServiceImpl implements MapperService {
    private int getRandom() {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    @Override
    public Course courseDtoToCourse(CourseDto courseDto) {
        Course cc = new Course();
        cc.setCode(courseDto.getCode());
        cc.setName(courseDto.getName());
        cc.setId(getRandom());
        return cc;
    }

    @Override
    public CourseDto courseToCourseDto(Course course) {
        CourseDto cc = new CourseDto();
        cc.setCode(course.getCode());
        cc.setName(course.getName());
        cc.setId(course.getId());
        return cc;
    }

    @Override
    public StudentDto studentToStudentDto(Student student) {
        StudentDto ss = new StudentDto();
        ss.setId(student.getId());
        ss.setFirstName(student.getFirstName());
        ss.setLastName(student.getLastName());
        ss.setEmail(student.getEmail());
        ss.setMajor(student.getMajor());
        List<CourseDto> courses = new ArrayList<>();
        for(Course course: student.getCoursesTaken()) {
            courses.add(courseToCourseDto(course));
        }
        ss.setCoursesTaken(courses);
        return ss;
    }

    @Override
    public Student studentDtoToStudent(StudentDto student) {
        Student ss = new Student();
        ss.setId(getRandom());
        ss.setFirstName(student.getFirstName());
        ss.setLastName(student.getLastName());
        ss.setEmail(student.getEmail());
        ss.setMajor(student.getMajor());
        List<Course> courses = new ArrayList<>();
        if(student.getCoursesTaken() != null) {
            for (CourseDto course : student.getCoursesTaken()) {
                courses.add(courseDtoToCourse(course));
            }
        }
        ss.setCoursesTaken(courses);
        return ss;
    }
}
