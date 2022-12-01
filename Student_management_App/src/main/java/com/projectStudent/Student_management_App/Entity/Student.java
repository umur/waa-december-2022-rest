package com.projectStudent.Student_management_App.Entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student {
   private boolean deleted;
   private int id;
   private String firstname;
   private String lastname;
   private String email;
   private String major;

   private List<Course> courses_taken;

public Student(){

}
public Student(int id , String firstname,String lastname,String email,String major){
   this.id=id;
   this.firstname=firstname;
   this.lastname= lastname;
   this.email=email;
   this.major=major;
   this.courses_taken = new ArrayList<>();
}

   public void  addCourse(Course course) {
       this.courses_taken.add(course);
   }



}
