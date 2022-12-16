package edu.miu.lab2.service.impl;

import edu.miu.lab2.entity.Course;
import edu.miu.lab2.entity.Student;
import edu.miu.lab2.repo.StudentRepo;
import edu.miu.lab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    public List<Student> getAllStudents(){
        return studentRepo.getAllStudents();
    }

    public void addStudent(Student student){
        studentRepo.save(student);
    }

    public Student getStudentById(int id){
        return studentRepo.getByID(id);
    }

    public void deleteStudent(int id){
        studentRepo.deleteStudent(id);
    }

    @Override
    public void updateStudent(int id, Student student) {

    }

    public List<Student> getStudentByMajor(String major){ return studentRepo.getStudentsByMajor(major);}

    public List<Course> getStudentCourses(int id){ return studentRepo.getCoursesByStudentId(id);}

}
