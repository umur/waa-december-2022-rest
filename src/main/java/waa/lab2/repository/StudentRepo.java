package waa.lab2.repository;

import org.springframework.stereotype.Repository;
import waa.lab2.entity.Course;
import waa.lab2.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
@Repository
public class StudentRepo {
    static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "A", "X", "A@X", "major1",
                        Arrays.asList(
                                new Course(1, "WAA", "CS545"),
                                new Course(2, "MWA", "CS572")
                        )));
        students.add(new Student(2, "B", "Y", "B@Y", "major2",
                        Arrays.asList(
                                new Course(2, "MWA", "CS572")
                        )));
        students.add(new Student(3, "C", "Z", "C@C", "major3",
                Arrays.asList(
                        new Course(2, "MWA", "CS572"),
                        new Course(3, "WAP", "CS472")
                )));
    }

    public void save(Student student) {
        students.add(student);
    }

    public Student getById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().get();
    }

    public List<Student> getAll() {
        return students;
    }

    public boolean delete(int id) {
        return students.removeIf(s -> s.getId() == id);
    }

    public void update(int id, Student student) {
        delete(id);
        save(student);
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return students.stream()
                .filter(s -> s.getId() == studentId)
                .findFirst().get()
                .getCourseTaken();
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter(s -> s.getMajor().equals(major))
                .toList();
    }
}
