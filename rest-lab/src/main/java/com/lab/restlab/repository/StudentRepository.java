package com.lab.restlab.repository;

import com.lab.restlab.entity.Course;
import com.lab.restlab.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1, "John", "Doe", "john@abc.com", "MSc"));
        studentList.add(new Student(2, "Jane", "Doe", "jane@abc.com", "MSc"));
        studentList.add(new Student(3, "John", "Mayer", "johnm@abc.com", "MSD"));
        studentList.add(new Student(4, "John", "Cena", "youcantseeme@abc.com", "WWE"));
    }

    public List<Student> getAll(){
        return studentList;
    }

    public Student getById(int id) {
        return studentList.stream().filter(s -> s.getId() == id).findAny().get();
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentList.stream().filter(s -> s.getMajor().equals(major)).toList();
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return studentList.stream().filter(s -> s.getId() == studentId).findAny().get().getCourseList();
    }

    public void save(Student student) {
        studentList.add(student);
    }

    public Student update(int id, Student student) {
        for(int i = 0 ; i < studentList.size(); i++){
            if(studentList.get(i).getId() == id){
                studentList.set(i, student);
            }
        }
        return student;
    }

    public void delete(int id) {
        studentList = studentList.stream().filter(s -> s.getId() != id).toList();
    }
}
