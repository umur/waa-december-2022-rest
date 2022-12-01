package com.example.lab2.service.impl;

import com.example.lab2.dto.StudentBasicDto;
import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import com.example.lab2.repository.StudentRepo;
import com.example.lab2.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;

    private ModelMapper modelMapper;

   public StudentServiceImpl(StudentRepo studentRepo, ModelMapper modelMapper){
       this.modelMapper=modelMapper;
       this.studentRepo=studentRepo;
   }

    public void save(Student s){
        studentRepo.save(s);
    }
    public String deleteStudentById(int id){return studentRepo.deleteStudentById(id);}
    public void updateStudent(int id, StudentBasicDto student){
       studentRepo.updateStudent(id,modelMapper.map(student,Student.class));
   }

    public List<StudentBasicDto> getAllStudent(){
        List<Student> students = studentRepo.getAllStudent();
       return students
               .stream()
               .map(student->modelMapper.map(student, StudentBasicDto.class))
               .toList();
    }
    public StudentBasicDto getStudentById(int id){
        Student student = studentRepo.getStudentById(id);
       return modelMapper.map(student,StudentBasicDto.class);
    }

    public List<Student> getStudentsByMajor(String major) {

       return studentRepo.getStudentsByMajor(major);
    }
    public  List<Course> getCourseByStudentId(int id) {

       return studentRepo.getCourseByStudentId(id);
    }






}
