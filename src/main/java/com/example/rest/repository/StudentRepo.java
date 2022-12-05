package com.example.rest.repository;


import com.example.rest.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepo {
    static List<Student> students = new ArrayList<>();

    static{
        students.add( new Student(1,"MOhammed","Uddin","mo@gmail.com","compro", Arrays.asList(CourseRepo.c1, CourseRepo.c2)));
        students.add( new Student(2,"Max","Pro","max@gmail.com","compro",Arrays.asList(CourseRepo.c1, CourseRepo.c3)));
        students.add( new Student(3,"David","Jhonson","david@gmail.com","compro",Arrays.asList(CourseRepo.c2, CourseRepo.c3)));
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

