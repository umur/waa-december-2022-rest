package lab.waa.rest.repository;

import lab.waa.rest.entity.Course;
import lab.waa.rest.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    ;
    static List<Student> students = new ArrayList<>();

    static {
        var courseRepo = new CourseRepo();
        students.add(new Student(1, "Prabesh", "KC",
                "prabesh@email.com", "CS",
                new ArrayList<Course>(
                        List.of(
                                courseRepo.getById(1),
                                courseRepo.getById(2),
                                courseRepo.getById(5)
                        )
                )));
        students.add(new Student(2, "Karna", "Shrestha",
                "karna@email.com", "cs",
                new ArrayList<Course>(
                        List.of(
                                courseRepo.getById(2),
                                courseRepo.getById(3),
                                courseRepo.getById(6)
                        )
                )));
        students.add(new Student(3, "John", "Digger",
                "digger@email.com", "MBA",
                new ArrayList<Course>(
                        List.of(
                                courseRepo.getById(3),
                                courseRepo.getById(4),
                                courseRepo.getById(5)
                        )
                )));
    }

    public List<Student> getStudents(int offset, int count) {
        if (count == 0)
            count = 5;
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

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter(s -> s.getMajor()
                        .equalsIgnoreCase(major))
                .toList();
    }

    public List<Course> getCoursesByStudentId(int studentId){
        return getById(studentId).getCoursesTaken();
    }
}
