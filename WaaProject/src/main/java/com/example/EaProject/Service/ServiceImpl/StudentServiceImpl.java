package com.example.EaProject.Service.ServiceImpl;

import com.example.EaProject.Entity.Course;
import com.example.EaProject.Entity.Student;
import com.example.EaProject.Repository.StudentRepo;
import com.example.EaProject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> GetStudentsByMajor(String major) {

        return studentRepo
                .getAll()
                .stream()
                .filter(item -> item
                        .getCourseTaken()
                        .stream()
                        .filter(x -> x.getName().equals(major)).count() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public void Add(Student student) {
        studentRepo.add(student);
    }

    @Override
    public void Update(Student student, int id) {
        studentRepo.update(student, id);
    }

    @Override
    public void Delete(int id) {
        studentRepo.Delete(id);
    }

    @Override
    public List<Student> GetAll() {
      return studentRepo.getAll();
    }


}
