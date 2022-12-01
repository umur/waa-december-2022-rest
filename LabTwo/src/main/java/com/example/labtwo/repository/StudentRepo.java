package com.example.labtwo.repository;

import com.example.labtwo.entity.Course;
import com.example.labtwo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    static List<Student> students = new ArrayList<>();

    static {
        Student s1 = new Student(01,"Maheder", "Abreha","mahderabb@gmail.com","Compro", CourseRepo.courses);
        Student s2 = new Student(02,"Gilbert", "Mumbere","Gilbert@gmail.com","Compro", CourseRepo.courses);
        Student s3 = new Student(03,"Liya", "Abebe","Ma123@gmail.com","MBA", CourseRepo.courses);


        students.add(s1);
        students.add(s2);
        students.add(s3);

    }

    public List<Course> getCoursesByStudentId(int id){
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst().get()
                .getCoursesTaken();
    }


}
