package edu.miu.lab2.repo;

import edu.miu.lab2.entity.Course;
import edu.miu.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {

    static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "Diptesh", "Shrestha", "diptesh.shrestha@miu.edu", "Compro", null, false));
    }
    public void save(Student student) {
        studentList.add(student);
    }

    public Student getByID(int id) {
        return studentList.stream().filter(i -> i.getId() == id && !i.isDeleted()).findFirst().get();
    }

    public void updateStudent(int id, Student student) {
        //studentList.stream().filter(i -> i.getId() == id).findFirst().get();
        int index = studentList.indexOf(getByID(id));

        studentList.set(index, student);

        //studentList.stream().filter(i -> i.getId() == id).findFirst().get().setDeleted(true);
    }

    public void deleteStudent(int id) {
        studentList.stream().filter(i -> i.getId() == id).findFirst().get().setDeleted(true);
    }

    public List<Student> getAllStudents() {
        return studentList;
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentList.stream().filter(i -> i.getMajor().equals(major)).collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int studentId) {

        return getByID(studentId).getCourseTaken();

//        return studentList.stream().filter(i -> i.getId() == studentId)
//                .flatMap(student -> student.getCourseTaken().stream())
//                .collect(Collectors.toList());
    }
}