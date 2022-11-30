package edu.miu.lab2.repository;

import edu.miu.lab2.model.Course;
import edu.miu.lab2.model.Student;
import edu.miu.lab2.model.dto.StudentDTO;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    static List<Student> students = new ArrayList<>();
    static {
        List<Course> courseLists1 = new ArrayList<>();
        courseLists1.add(CourseRepo.courseList.get(0));
        courseLists1.add(CourseRepo.courseList.get(1));
        courseLists1.add(CourseRepo.courseList.get(2));

        List<Course> courseLists2 = new ArrayList<>();
        courseLists2.add(CourseRepo.courseList.get(0));
        courseLists2.add(CourseRepo.courseList.get(1));

        List<Course> courseLists3 = new ArrayList<>();
        courseLists3.add(CourseRepo.courseList.get(2));


        students.add(new Student(1, "Joy", "Lenon", "joy@gmail.com", "Student", courseLists1));
        students.add(new Student(1, "Anna", "Karl", "anna@gmail.com", "Student", courseLists2));
        students.add(new Student(1, "George", "Marie", "george@gmail.com", "Student", courseLists3));
    }
    public List<Student> findAllStudents(){
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void deleteStudent(int id){
        Student deleteStudent = null;
        for (Student student: students) {
            if (student.getId() == id){
                deleteStudent = student;
            }
        }
        students.remove(deleteStudent);
    }

    public void updateStudent(int id, Student student){
        Student updatedStudent = null;
        for (Student st: students) {
            if (st.getId() == id){
                updatedStudent = st;
            }
        }
        students.set(students.indexOf(updatedStudent), student);
    }
    public List<Student> getStudentsByMajor(String major){
        return students
                .stream()
                .filter(s -> s.getMajor().equals(major))
                .toList();
    }

    public List<Course> getCoursesByStudentId(int studentId){
        return students
                .stream()
                .filter(s -> s.getId() == studentId)
                .flatMap(s -> s.getCoursesTaken().stream())
                .toList();
    }

}
