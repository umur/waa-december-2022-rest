package miu.edu.waa.lab2.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.NoArgsConstructor;
import miu.edu.waa.lab2.model.Course;
import miu.edu.waa.lab2.model.Student;

@Repository
@NoArgsConstructor
public class StudentRepo {
    static List<Student> students = new ArrayList<>();

    static {
        List<Course> courses1 = new ArrayList<>();
        courses1.add(CourseRepo.courses.get(0));
        courses1.add(CourseRepo.courses.get(1));

        List<Course> courses2 = new ArrayList<>();
        courses2.add(CourseRepo.courses.get(1));
        courses2.add(CourseRepo.courses.get(2));

        List<Course> courses3 = new ArrayList<>();
        courses3.add(CourseRepo.courses.get(0));
        courses3.add(CourseRepo.courses.get(2));

        students.add(new Student(1, "John", "Higgins", "john@gmail.com", "BigData", courses1));
        students.add(new Student(1, "Jack", "Ross", "jackjohn@gmail.com", "BigData", courses2));
        students.add(new Student(1, "Carl", "Blue", "carl@gmail.com", "", courses3));
    }

    public boolean addStudent(Student newStudent) {
        try {
            students.add(newStudent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        return students
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Student> getStudentsByMajor(String major) {
        return students
                .stream()
                .filter(s -> s.getMajor().equals(major))
                .toList();
    }

    public Student updateStudent(int id, Student newStudent) {
        Integer indexOfStudent = students
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .map(c -> c.getId())
                .orElse(-1);

        return students.set(indexOfStudent, newStudent);
    }

    public boolean removeStudent(int id) {
        return students.removeIf(c -> c.getId() == id);
    }
}
