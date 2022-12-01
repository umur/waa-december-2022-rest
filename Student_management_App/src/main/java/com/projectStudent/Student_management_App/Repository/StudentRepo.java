package com.projectStudent.Student_management_App.Repository;

import com.projectStudent.Student_management_App.Entity.Course;
import org.springframework.stereotype.Repository;
import com.projectStudent.Student_management_App.Entity.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class StudentRepo {

    static List<Student> students = new ArrayList<>();

    static {
        Student std1 = new Student(1, "Lovenson", "Rodelin","lovr@edi.edu","undergrad");
        Student std2 = new Student(2, "Lovensona", "Rodelino","lovr@edi.edu","undergrad");
        Student std3 = new Student(3, "Loven", "Rodel","lov@edi.edu","undergrad");
        Student std4 =  new Student(4, "Lova", "Rodeli","lova@edi.edu","grad");

        std1.addCourse(new Course(100,"MPP","CS475"));
        std1.addCourse(new Course(101,"FPP","CS477"));

        std2.addCourse(new Course(100,"MPP","CS475"));
        std2.addCourse(new Course(101,"FPP","CS477"));

        std3.addCourse(new Course(100,"MPP","CS475"));
        std3.addCourse(new Course(101,"FPP","CS477"));

        std4.addCourse(new Course(100,"MPP","CS475"));
        std4.addCourse(new Course(101,"FPP","CS477"));

        students.add(std1);
        students.add(std2);
        students.add(std3);
        students.add(std4);
//        students.add(new Student(1, "Lovenson", "Rodelin","lovr@edi.edu","undergrad"));
//        students.add(new Student(2, "Lovensony", "Rodelina","lovre@edi.edu","undergrad"));
//        students.add(new Student(3, "Loven", "Rodel","lov@edi.edu","undergrad"));
//        students.add(new Student(4, "Lova", "Rodeli","lova@edi.edu","grad"));

    }

    public List<Student> getAll(){
        return students;
    }

    public String addStudent(Student student){
        students.add(student);
        return "Successfully Added";
    }

    public String modStudent(Student student) {
         students.stream().filter(s->s.getId()==student.getId()).forEach(std -> {
            std.setMajor(student.getMajor());
            std.setLastname(student.getLastname());
         });
        return "Success";
    }

    public String delStudent(int id){
        students.stream().filter(s->s.getId()==id).findAny().get().setDeleted(true);
    return "Sucessfully deleted";
    }

    public List<Student> getStudentsByMajor(String major){

     return  students.stream().filter(s->s.getMajor().equals(major)).collect(Collectors.toList());
//        List<Student> st = new ArrayList<>();
//        for(Student stud : students){
//            if(stud.getMajor().equals(major)){
//                st.add(stud);
//
//            }
//        }
//        return st;
    }

    public List<Student> getCourseByStudentID(int stdId){

        return students.stream().filter(s->s.getId()==stdId).collect(Collectors.toList());
    }

}
