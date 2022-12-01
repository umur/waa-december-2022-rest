package Waa.Lab2.Repository;

import Waa.Lab2.Entity.Course;
import Waa.Lab2.Entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepo {
    public static  Student s1;
    public static  Student s2;
public static List<Student> students= new ArrayList<>();
static {
    Student s1=new Student(10,"Eudis","Muhangi",
            "eudismuhangi@gmail.com","Compro",
            Arrays.asList(CourseRepo.c1, CourseRepo.c2));
    Student s2=new Student(11,"Gilbert","Mumbere",
            "gm@gmail.com","MSD",
            Arrays.asList(CourseRepo.c1));

    students.add(s1);
    students.add(s2);

}


}


