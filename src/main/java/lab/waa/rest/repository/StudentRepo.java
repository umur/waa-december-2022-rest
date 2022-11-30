package lab.waa.rest.repository;

import lab.waa.rest.entity.Course;
import lab.waa.rest.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepo {

    static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Prabesh", "KC",
                "prabesh@email.com", "Computer Science",
                new ArrayList<Course>()));
        students.add(new Student(2, "Karna", "Shrestha",
                "karna@email.com", "Computer Science",
                new ArrayList<Course>()));
    }

    public List<Student> getStudents(int offset, int count) {
        return students.stream()
                .skip(offset)
                .limit(count).toList();
    }

    public Student getById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst().get();
    }

    public void deleteById(int id) {
        students.removeIf(s -> s.getId() == id);
    }

    public void updateById(int id, Student student) {
        students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .ifPresent(s -> {
                    if (student.getFirstName() != null) s.setFirstName(student.getFirstName());
                    if (student.getLastName() != null) s.setLastName(student.getLastName());
                    if (student.getMajor() != null) s.setMajor(student.getMajor());
                    if (student.getEmail() != null) s.setEmail(student.getEmail());
                });
    }

    public void save(Student student) {
        students.add(student);
    }

    public void addCourseTaken(int studentId, Course course) {
        students.stream()
                .filter(s -> s.getId() == studentId)
                .findFirst()
                .ifPresent(s -> {
                    if (s.getCoursesTaken() == null) {
                        s.setCoursesTaken(new ArrayList<Course>());
                    }
                    s.getCoursesTaken().add(course);
                });
    }
}
