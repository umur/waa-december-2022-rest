package edu.miu.lab2_assignment.repository;

import edu.miu.lab2_assignment.entity.Course;
import edu.miu.lab2_assignment.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
     static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(4001, "Camilla", "Gilbert", "gilbert.mumbere@miu.edu","Compro", CourseRepo.courseList ));
        studentList.add(new Student(4002,"Gilbert","Muneka", "gilbert.mumbere@miu.edu","Compro",CourseRepo.courseList));
    }

    public List<Student> getStudentList() {
        return studentList.stream()
                .filter(student -> !student.isDeleted()).toList();
    }

    public Student getById(int id){
        return studentList.stream().filter(course ->course.getId()==id && !course.isDeleted())
                .findFirst().get();
    }

    //Implementing CRUD
    public void save(Student student){ studentList.add(student);}

    public void update (int id, Student student){
        int i = studentList.indexOf(getById(id));
        studentList.set(i,student);
    }

    public void deleteById(int id){
        studentList.stream().filter(student -> student.getId()==id)
                .findFirst().get().setDeleted(true);
    }


}
