package Waa.Lab2.Services.Serviceimpl;

//import Waa.Lab2.Entity.Student;
import Waa.Lab2.Entity.Course;
import Waa.Lab2.Entity.Student;
import Waa.Lab2.Repository.StudentRepo;
import Waa.Lab2.Services.StundentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentImpl implements StundentService {
   @Autowired
    public static StudentRepo repo;

    public  Student getStudentsByMajor(String major) {
        return getAllStudents().stream().

                filter(x->x.getMajor()==major).
                findFirst().get();
    }



        public List<Course> getCoursesByStudentId(int studentId) {
            return getAllStudents()
                    .stream()
                    .filter(y->y.getId() == studentId)
                    .map(x->x.getCoursesTaken())
                    .findFirst().get();

        }


    public static List<Student> getAllStudents() {
        return repo.students;
    }

    public void add(Student student) {
        repo.students.add(student);
    }

    public void update(Student student, int id) {
        if (student != null) {
            Student item = getById(id);
            if (item != null) {
                repo.students.set(repo.students.indexOf(item), student);
            }
        }
    }
    public void Delete(int id) {
        Student item = getById(id);
        if (item != null) {
            repo.students.remove(repo.students.indexOf(item));
        }
    }

    private Student getById(int id)
    {
        return repo.students.stream().
                filter(x -> x.getId() == id).findFirst().get();
    }


}
