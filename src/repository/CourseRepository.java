package repository;

import entity.Course;

import java.util.List;

public class CourseRepository {
    static List<Course> courses;
    static{
        //fill the list of courses
    }

    public List<Course> getAll(){return courses;}
    public Course getById(int id){return courses.stream().filter(s->s.getId()==id).findAny().get();}
    public void update(int id, Course student){
        Course obj=getById(id);
        obj.setId(student.getId());
        obj.setName(student.getName());
        obj.setCode(student.getCode());
    }
    public void delete(int id){
        courses.remove(courses.stream().filter(s->s.getId()==id).findAny().get());
    }
    public void add(Course s){
        courses.add(s);
    }
}
