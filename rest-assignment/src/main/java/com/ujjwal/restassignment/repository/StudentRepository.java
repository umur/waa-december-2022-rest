package com.ujjwal.restassignment.repository;

import com.ujjwal.restassignment.entity.Course;
import com.ujjwal.restassignment.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
    //    creating arraylist for storing the data
    private static List<Student> studentList = new ArrayList<>();

    //    initializing the course list with values
    static {
        var courseRepository = new CourseRepository();
        studentList.add(new Student(1, "Ujjwal", "Humagain", "ujjwal.humagain@miu.edu", "Compro",
                new ArrayList<>(
                        List.of(
                                courseRepository.getById(1),
                                courseRepository.getById(2),
                                courseRepository.getById(3)
                        )
                )));
        studentList.add(new Student(2, "John", "Doe", "john.doe@miu.edu", "MSD",
                new ArrayList<>(
                        List.of(
                                courseRepository.getById(1),
                                courseRepository.getById(2),
                                courseRepository.getById(4)
                        )
                )));
        studentList.add(new Student(3, "Jane", "Doe", "jane.doe@miu.edu", "MBA",
                new ArrayList<>(
                        List.of(
                                courseRepository.getById(2),
                                courseRepository.getById(4),
                                courseRepository.getById(1)
                        )
                )));
    }

    //    adding a new student
    public void save(Student student){
        studentList.add(student);
    }

    //   getting all students
    public List<Student> getAll(){
        return studentList;
    }
    //   get a student by id
    public Student getById(int id){
        Optional<Student> s = studentList.stream().filter(student -> student.getId() == id).findFirst();
        return s.orElse(null);
    }
    //    update a student
    public Student update(int id, Student student){
        for (Student student1 : studentList){
            if (student1.getId() == id){
                studentList.set(id,student);
            }
        }
        return student;
    }
    //    delete a student
    public void delete(int id){
        studentList.removeIf(student -> student.getId()==id);
    }

    //    get students by major
    public List<Student> getStudentsByMajor(String major){
        return studentList.stream().filter(student -> student.getMajor().equals(major)).toList();
    }
    //    get courses of a student
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentList.stream().filter(student -> student.getId() == studentId).findFirst().get().getCoursesTaken();
    }
}
