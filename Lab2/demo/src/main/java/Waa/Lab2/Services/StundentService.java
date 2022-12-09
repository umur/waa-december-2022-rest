package Waa.Lab2.Services;

import Waa.Lab2.Entity.Course;
import Waa.Lab2.Entity.Student;

import java.util.List;

public interface StundentService {
    public List <Student> getStudentsByMajor(String major);
    public List<Course> getCoursesByStudentId(int id);

}
