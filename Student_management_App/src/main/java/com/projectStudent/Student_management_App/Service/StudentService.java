package com.projectStudent.Student_management_App.Service;


import com.projectStudent.Student_management_App.Entity.Student;
import com.projectStudent.Student_management_App.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

     @Autowired
    StudentRepo studentRepo;
    public List<Student> getAll(){
      return   studentRepo.getAll();

    }

    public String addStudent(Student student){

       return  studentRepo.addStudent(student);
    }

    public String modStudent(Student student) {
        return  studentRepo.modStudent(student);
    }

    public String delStudent(int id){
        return studentRepo.delStudent(id);
    }

    public List<Student> getStudentByMajor(String major){
        return studentRepo.getStudentsByMajor(major);
    }

    public List<Student> getCourseByStudentID(int stdId){

        return studentRepo.getCourseByStudentID(stdId);
    }

}
