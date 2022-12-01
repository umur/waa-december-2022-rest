package Waa.lab2.services;

import Waa.lab2.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> GetStudentsByMajor(String major);

    public void Add(Student student);
    public void Update(Student student, int id);
    public void Delete(int id);
    public List<Student> GetAll();

}
