package Waa.lab2.repository;


import Waa.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class StudentRepo {
   public static List<Student> students = new ArrayList<>();
    static{
        Student s1= new Student(1,"H","n","tya@hdi","Computer", Arrays.asList(CourseRepo.c1,CourseRepo.c2));
        Student s2= new Student(2,"Ha","na","tya@hdi","Computer", Arrays.asList(CourseRepo.c2));
        students.add(s1);
        students.add(s2);
       // students.add(new Student("H","n","tya@hdi","Computer", Arrays.asList("wap","waa")) );
        //students.add(new Student("Ha","na","atya@hdi","HComputer", Arrays.asList("wapa","waat")) );
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
