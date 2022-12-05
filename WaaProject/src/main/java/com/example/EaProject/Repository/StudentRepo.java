package com.example.EaProject.Repository;

import com.example.EaProject.Entity.Course;
import com.example.EaProject.Entity.Student;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.EaProject.Repository.CourseRepo.courses;

@Repository
public class StudentRepo {
    public static List<Student> students = new ArrayList<>();


    static {
        Student s1 = new Student(1, "Abhay", "Rawal", "abhay.rawal@miu.edu", "cs", 4.00, Arrays.asList(CourseRepo.c1, CourseRepo.c2));
        Student s2 = new Student(2, "Deeptesh", "Shrestha", "abhay.rawal@miu.edu", "cs", 4.00, Arrays.asList(CourseRepo.c1, CourseRepo.c3));
        Student s3 = new Student(3, "Utsab", "Sapkota", "abhay.rawal@miu.edu", "cs", 4.00, Arrays.asList(CourseRepo.c2, CourseRepo.c3));
        students.add(s1);
        students.add(s2);
        students.add(s3);
    }

    public List<Student> getAll() {
        return students;
    }

    public void add(Student student) {
        students.add(student);
    }

    public void update(Student student, int id) {
        if (student != null) {
            Student item = findById(id);
            if (item != null) {
                students.set(students.indexOf(item), student);
            }
        }
    }
    public void Delete(int id) {
        Student item = findById(id);
        if (item != null) {
            students.remove(students.indexOf(item));
        }
    }

    private Student findById(int id)
    {
       return students.stream().filter(x->x.getId()== id).findFirst().get();
    }
}
