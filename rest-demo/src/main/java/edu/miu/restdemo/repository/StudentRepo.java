package edu.miu.restdemo.repository;

import edu.miu.restdemo.entity.Course;
import edu.miu.restdemo.entity.Student;
import edu.miu.restdemo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {

    static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Astudent", "Lastname1", "a.student@miu.edu", "ComPro",
                Arrays.asList(
                    new Course(1, "MPP", "CS401"),
                    new Course(2, "WAP", "CS472")
                )));
        students.add(new Student(2, "Bstudent", "Lastname2", "b.student@miu.edu", "MSTC",
                Arrays.asList(
                        new Course(3, "MWA", "CS572")
                )));
        students.add(new Student(3, "Cstudent", "Lastname3", "c.student@miu.edu", "ComPro",
                Arrays.asList(
                        new Course(3, "MWA", "CS572")
                )));
        students.add(new Student(4, "Dstudent", "Lastname4", "d.student@miu.edu", "ComPro",
                Arrays.asList(
                        new Course(1, "MPP", "CS401"),
                        new Course(2, "WAP", "CS472"),
                        new Course(3, "MWA", "CS572"),
                        new Course(4, "WAA", "CS545")
                )));
    }

    public void save(Student s) {
        students.add(s);
    }

    public Student getById(int id) {
        return students.stream()
                .filter(c -> c.getId() == id)
                .findFirst().get();
    }

    public List<Student> getAllStudents(){
        return students;
    }


    public boolean delete(int id) {
       return students.removeIf(p -> p.getId() == id);
    }

    public List<Student> getStudentsByMajor(String major){
        System.out.printf("get StudentByMajor in repo %s%n", major);

        return students.stream()
                .filter(s -> s.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int studentId){
        System.out.printf("get getCoursesByStudentId in repo %s%n", studentId);

        return students.stream()
                .filter(s -> s.getId() == studentId)
                .findFirst().get()
                .getCoursesTaken();
    }

    public void update(int id, Student s) {
        delete(id);
        save(s);
    }

}
