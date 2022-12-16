package repository;

import entity.Student;

import java.util.List;

public class StudentRepository {
    static List<Student> studentList;
    static{
        //fill the list of students
    }
    public List<Student> getAll(){return studentList;}
    public Student getById(int id){return studentList.stream().filter(s->s.getId()==id).findAny().get();}
    public void update(int id, Student student){
        Student obj=getById(id);
        obj.setId(student.getId());
        obj.setFirstName(student.getFirstName());
        obj.setLastName(student.getLastName());
        obj.setEmail(student.getEmail());
        obj.setMajor(student.getMajor());
    }
    public void delete(int id){
        studentList.remove(studentList.stream().filter(s->s.getId()==id).findAny().get());
    }
    public void add(Student s){
        studentList.add(s);
    }
}
