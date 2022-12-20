package edu.miu.w1d2rest.repository;

import edu.miu.w1d2rest.entity.Course;
import edu.miu.w1d2rest.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(5001, "Ram", "Thapa", "ram.thapa@miu.edu", "compro",CourseRepo.courseList));
        studentList.add(new Student(5002, "Shyam", "Thapa", "shyam.thapa@miu.edu", "compro",CourseRepo.courseList));
        studentList.add(new Student(5003, "Hari", "Thapa", "hari.thapa@miu.edu", "compro",CourseRepo.courseList));
        studentList.add(new Student(5004, "Gagan", "Thapa", "gagan.thapa@miu.edu", "mba",CourseRepo.courseList));
        studentList.add(new Student(5005, "Raman", "Thapa", "raman.thapa@miu.edu", "mba",CourseRepo.courseList));
    }

    public List<Student> getAll() {
        return studentList.stream()
                .filter(student -> !student.isDeleted())
                .toList();
    }

    public List<Student> getAllByMajor(String major) {
        return studentList.stream()
                .filter(student -> student.getMajor().equals(major) && !student.isDeleted())
                .toList();
    }

    public List<Course> getCoursesByStudentId(int id) {
        return studentList.stream()
                .filter(student -> student.getId() == id && !student.isDeleted())
                .findFirst()
                .get()
                .getNotDeletedCourseTaken();
    }

    public Student getById(int id) {
        return studentList.stream()
                .filter(course -> course.getId() == id && !course.isDeleted())
                .findFirst()
                .get();
    }

    public void save(Student student){
        studentList.add(student);
    }

    public void update(int id, Student student){
        //find index using id first
        int index = studentList.indexOf(getById(id));
        studentList.set(index, student);
    }

    public void deleteById(int id){
        studentList.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .get().setDeleted(true);

    }

    public void deleteCourseOfStudent(int id){
        studentList.stream()
                .map(student -> {
                    var coursesTaken = student.getCoursesTaken();
                    coursesTaken.stream()
                            .filter(c -> c.getId() == id)
                            .findFirst()
                            .get()
                            .setDeleted(true);
                    return student;
                });
var dd = studentList;
    }
}
