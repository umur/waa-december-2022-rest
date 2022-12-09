package Waa.Lab2.Repository;

import Waa.Lab2.Entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    public static Course c1;
    public static Course c2;
    public static Course c3;

    public static List<Course> courses= new ArrayList<>();
    static {
      Course c1= new Course("WAP",1,255);
        Course c2=new Course("Algorithm",2,256);
        Course c3=new Course("WAA",3,257);
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
    }

    public List<Course> getAllCourses(){
        return courses;
    }
     public void add(Course newCourse){
        courses.add(newCourse);
     }

     public void delete(int id){
         Course item = getById(id);
         if (item != null) {
             courses.remove(courses.indexOf(item));
         }
     }
    private Course getById(int id)
    {
        return courses.stream().
                filter(x->x.getId()== id).findFirst().get();
    }
     }

