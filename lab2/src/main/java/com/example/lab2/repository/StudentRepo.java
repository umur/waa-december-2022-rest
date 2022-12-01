package com.example.lab2.repository;


import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    static List<Course> course1 = List.of(
            new Course(101,"Modern Programming Practices","MPP" ),
            new Course(102,"Fundamental of Programming Practices","FPP" ),
            new Course(103,"Database","DB" )
    );
   static List<Course> course2 = List.of(
            new Course(101,"Modern Programming Practices","MPP" ),
            new Course(103,"Database","DB" )
    );

    static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1,"Hridaya","Kandel", "hridaya.kandel@miu.edu","Science",course1));
        students.add(new Student(2,"Sameer","Adhikari", "samere.adhika.rawal@miu.edu","Computer Science",course2));
        students.add(new Student(3,"Avay","Rawal", "Avay.rawal@miu.edu","Computer Science",course1));
        students.add(new Student(4,"Sandesh","Raut", "sandesh.raut@miu.edu","Computer Science",course2));
    }
    public void save(Student s){
        students.add(s);
    }
    public List<Student> getAllStudent(){
        return students
                .stream()
                .filter(s->!s.isDeleted()).toList();
    }
    public Student getStudentById(int id){
        return students
                .stream()
                .filter(s->s.getId()==id && !s.isDeleted())
                .findFirst().get();
    }

    public List<Student> getStudentsByMajor(String major) {
        return students
                .stream()
                .filter(s->s.getMajor().equals(major))
                .toList();
    }
    public String deleteStudentById(int id){
        students
                .stream()
                .filter(s->s.getId()==id)
                .findFirst().get().setDeleted(true);
        return "deleted";
    }
    public void updateStudent(int id, Student student){
        Student entry = getStudentById(id);

        entry.setId(student.getId());
        entry.setFirstName(student.getFirstName());
        entry.setLastName(student.getLastName());
        entry.setCoursesTaken(student.getCoursesTaken());
        entry.setMajor(student.getMajor());
        entry.setEmail(student.getEmail());

        students.add(entry);
    }

    public  List<Course> getCourseByStudentId(int id) {
        return getStudentById(id).getCoursesTaken();
    }
}
