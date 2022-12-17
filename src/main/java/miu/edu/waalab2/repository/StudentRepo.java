package miu.edu.waalab2.repository;

import com.sun.tools.jconsole.JConsoleContext;
import miu.edu.waalab2.entity.Course;
import miu.edu.waalab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class StudentRepo {
    static List<Student> studentList = new ArrayList<>();
    static List<Course> courses1 = Arrays.asList(new Course(1, "Computer", "cd234"), new Course(1, "Science", "sc345"), new Course(4, "Social", "so456"));
    static List<Course> courses2 = Arrays.asList( new Course(3, "Math", "mt344"), new Course(4, "Social", "so456"));
    static List<Course> courses3 = Arrays.asList(new Course(1, "Computer", "cd234"), new Course(1, "Science", "sc345"), new Course(4, "Social", "so456"));

    static {
        studentList.add(new Student(1, "Nirajan", "Karki", "nirajan@gmail.com", "Computer", courses1));
        studentList.add(new Student(2, "Bikram", "Limbu", "bikram@gmail.com", "Science", courses2));
        studentList.add(new Student(3, "Binod", "Gurung", "binod@gmail.com", "Computer", courses3));
    }


    public List<Student> getAllStudentByMajor(String major) {
        System.out.println(major);
        return studentList.stream().filter((student -> student.getMajor().equalsIgnoreCase(major))).collect(Collectors.toList());
    }
    public List<Course> getAllStudentByMajor(int studentId){
        return  studentList.stream().filter(student -> student.getId() == studentId).findFirst().get().getCoursesTaken();
    }
    public List<Student> getAllStudents(){
        return  studentList;
    }
}



