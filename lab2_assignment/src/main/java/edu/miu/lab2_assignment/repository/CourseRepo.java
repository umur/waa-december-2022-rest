package edu.miu.lab2_assignment.repository;

import edu.miu.lab2_assignment.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseRepo {

    static List<Course> courseList = new ArrayList<>();

    static {
        courseList.add(new Course(2002, "WAA", "001"));
        courseList.add(new Course(2003,"WAP", "003"));
    }
}
