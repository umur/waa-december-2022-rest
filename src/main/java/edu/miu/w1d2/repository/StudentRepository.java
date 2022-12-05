package edu.miu.w1d2.repository;

import edu.miu.w1d2.dto.CourseDto;
import edu.miu.w1d2.dto.StudentDto;
import edu.miu.w1d2.entity.Course;
import edu.miu.w1d2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    static List<Student> students = new ArrayList<>();
    public void save(Student st){
        students.add(st);
    }
    static {
        Student student = new Student(1, "meijuan", "long", "675601125@qq.com", "cs", false);
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(CourseRepository.courses.get(1));
        student.setCoursesTaken(courses);
        students.add(student);

        Student student1 = new Student(2, "hassan", "raza", "maxsecodod@gmail.com", "cs", false);
        ArrayList<Course> course2 = new ArrayList<Course>();
        course2.add(CourseRepository.courses.get(0));
        student.setCoursesTaken(course2);
        students.add(student1);

        Student student3 = new Student(3, "super", "man", "caeherffdf@qq.com", "math", false);
        student3.setCoursesTaken( CourseRepository.courses);
        students.add(student3);
    }
    public Student getStudentById(int id){
        return students.stream()
                .filter(x->x.getId()==id)
                .filter(x->!x.isDeleteFlag())
                .findFirst().get();
    }


    public void updateStudent(Student s,int id ){
        Student studentById = getStudentById(id);
        studentById.setId(s.getId());
        studentById.setEmail(s.getEmail());
        studentById.setMajor(s.getMajor());
        studentById.setFirstName(s.getFirstName());
        studentById.setLastName(s.getLastName());
    }

    public List<Student> getAllStudent(){
        return students.stream().filter(x->!x.isDeleteFlag()).collect(Collectors.toList());
    }
    public void delete(int id){
        this.getStudentById(id)
                .setDeleteFlag(true);
    }


    public List<Student> getStudentByMajor(String major) {
       return  students.stream()
                .filter(x->x.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Course> getCourseByStudentId(int studentId){
        return  getStudentById(studentId).getCoursesTaken().stream()
                .collect(Collectors.toList());
    }
}
