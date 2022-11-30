package edu.miu.lab2.restdemo.repository;

import edu.miu.lab2.restdemo.entity.Course;
import edu.miu.lab2.restdemo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRespo {

    static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Dave", "Degea", "dave@gmail.com", "CS", new ArrayList<Course>()));
        students.add(new Student(2,"Bruno","Fernandez","bruno@gmail.com","CS",new ArrayList<Course>()));
    }

    public Student getId(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst().get();
    }

    public void save(Student student) {
        students.add(student);
    }

    public void update (Student student, int id) {
        System.out.println(student);

        students = students.stream().map(s -> {
            if (s.getId() == id) {
//                s =student;
                s.setFirstName(student.getFirstName());
                s.setLastName(student.getLastName());

                System.out.println("Updating Student");
            }
            return s;
        }).collect(Collectors.toList());
    }

    public void delete(int id) {
        students.removeIf(s -> s.getId() != id);
    }

    public List<Student> findAll() {
        return students;
    }
}
