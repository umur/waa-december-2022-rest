package edu.miu.lab2.repository;

import edu.miu.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    List<Student> students = new ArrayList<>();

    public Student findById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .get();
    }

    public List<Student> getAll() {
        return students;
    }

    public boolean add(Student student) {
        try {
            students.add(student);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(int id, Student s) {
        try {
            Student studentToUpdate = findById(id);

            int index = students.indexOf(studentToUpdate);
            students.set(index, s);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            Student studentToDelete = findById(id);

            int index = students.indexOf(studentToDelete);
            students.remove(index);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
