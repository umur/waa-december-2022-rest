package waa.assignment.two.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import waa.assignment.two.model.Course;
import waa.assignment.two.model.Student;

@Repository
public class StudentRepo {
    static ArrayList<Student> students = new ArrayList<Student>();

    static {

        Course course1 = new Course(1, "WAA", "WAA-101");
        Course course2 = new Course(2, "MWA", "MWA-101");
        Course course3 = new Course(3, "EWA", "EWA-101");
        Course course4 = new Course(4, "EA", "EA-101");

        students.add(new Student(1, "John", "Smith", "test@email.com", "math", List.of(course1, course3)));
        students.add(new Student(2, "Henry", "Ford", "test@email.com", "cs", List.of(course3, course2)));
        students.add(new Student(3, "Samuel", "Adebari", "samie@email.com", "cs",
                List.of(course1, course3, course2, course4)));

    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Student getById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void save(Student student) {
        students.add(student);
    }

    public void update(int id, Student student) {
        for (Student student1 : students) {
            if (student1.getId() == id) {
                student1.setFirstName(student.getFirstName());
                student1.setLastName(student.getLastName());
                student1.setEmail(student.getEmail());
                student1.setMajor(student.getMajor());
                student1.setCoursesTaken(student.getCoursesTaken());
            }
        }
    }

    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public List<Student> getStudentsByMajor(String major) {
        List<Student> studentsByMajor = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getMajor().equals(major)) {
                studentsByMajor.add(student);
            }
        }
        return studentsByMajor;
    }

    public List<Course> getCoursesByStudentId(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student.getCoursesTaken();
            }
        }
        return null;
    }

}
