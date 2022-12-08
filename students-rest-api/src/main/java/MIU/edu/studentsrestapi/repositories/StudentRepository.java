package MIU.edu.studentsrestapi.repositories;

import MIU.edu.studentsrestapi.dtos.CourseDto;
import MIU.edu.studentsrestapi.dtos.StudentDto;
import MIU.edu.studentsrestapi.entities.Course;
import MIU.edu.studentsrestapi.entities.Student;
import MIU.edu.studentsrestapi.services.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    @Autowired
    private MapperService mapperService;
    private List<Student> students;

    public StudentRepository() {
        Course course1 = new Course(1, "FPP", "CS390");
        Course course2 = new Course(2, "MPP", "CS401");
        Course course3 = new Course(3, "MWA", "CS572");
        Course course4 = new Course(4, "WAA", "CS545");
        Course course5 = new Course(5, "ECO", "MBA101");
        Course course6 = new Course(6, "FIN", "MBA102");
        Course course7 = new Course(7, "DAT", "MBA103");
        Course course8 = new Course(8, "LIB", "MBA104");
        List<Course> courses = new ArrayList<>(){{
            add(course1); add(course2); add(course3); add(course4); add(course5); add(course6); add(course7); add(course8);
        }};

        List<Course> courseList1 = new ArrayList() {{add(courses.get(1)); add(courses.get(3));}};
        Student student1 = new Student(1, "Nirajan", "Karki", "nirajan.karki@miu.edu", "Compro", courseList1);

        List<Course> courseList2 = new ArrayList() {{add(courses.get(1)); add(courses.get(2)); add(courses.get(0));}};
        Student student2 = new Student(2, "Shivram", "Shrestha", "shivram.shrestha@miu.edu", "Compro", courseList2);

        List<Course> courseList3 = new ArrayList() {{add(courses.get(1)); add(courses.get(2)); add(courses.get(3)); add(courses.get(0));}};
        Student student3 = new Student(3, "Binod", "Gurung", "binod.gurung@miu.edu", "Compro", courseList3);

        List<Course> courseList4 = new ArrayList() {{add(courses.get(6)); add(courses.get(7));}};
        Student student4 = new Student(4, "Rasik", "Kunwar", "rasik.kunwar@miu.edu", "MBA", courseList4);

        List<Course> courseList5 = new ArrayList() {{add(courses.get(5)); add(courses.get(6)); add(courses.get(7));}};
        Student student5 = new Student(5, "Diptesh", "Shrestha", "diptesh.shrestha@miu.edu", "MBA", courseList5);

        this.students = new ArrayList(){{
            add(student1); add(student2); add(student3); add(student4); add(student5);
        }};
    }
    public List<StudentDto> getStudentsByMajor(String major) {
        return this.students.stream()
                .filter(student -> student.getMajor().toLowerCase().equals(major.toLowerCase()))
                .map(student -> mapperService.studentToStudentDto(student))
                .collect(Collectors.toList());
    }

    public List<CourseDto> getCoursesByStudentId(int studentId) {
        for(Student student : this.students) {
            if(studentId == student.getId()) {
                List<CourseDto> courses = new ArrayList<>();
                for(Course course: student.getCoursesTaken()) {
                    courses.add(mapperService.courseToCourseDto(course));
                }
                return courses;
            }
        }
        return new ArrayList<>();
    }

    public List<StudentDto> getStudents() {
        List<StudentDto> students = new ArrayList<>();
        for(Student student: this.students) {
            students.add(mapperService.studentToStudentDto(student));
        }
        return students;
    }

    public StudentDto getStudent(int studentId) {
        for(Student student: this.students) {
            if(student.getId() == studentId) {
                return mapperService.studentToStudentDto(student);
            }
        }
        return null;
    }

    public String deleteStudent(int studentId) {
        int pos = -1;
        for(int i = 0; i < this.students.size(); i++) {
            if(this.students.get(i).getId() == studentId) {
                pos = i;
            }
        }
        if(pos != -1) {
            this.students.remove(pos);
            return "Student with given studentId deleted!";
        } else {
            return "Student with given studentId not found!";
        }
    }

    public String updateStudent(int studentId, StudentDto studentDto) {
        boolean updateFlag = false;
        for(Student student: this.students) {
            if(student.getId() == studentId) {
                updateFlag = true;
                student.setFirstName(studentDto.getFirstName());
                student.setLastName(studentDto.getLastName());
                student.setEmail(studentDto.getEmail());
                student.setMajor(studentDto.getMajor());
            }
        }
        if(updateFlag) {
            return "Student with given studentId updated!";
        } else {
            return "Student with given studentId not found!";
        }
    }

    public String addStudent(StudentDto studentDto) {
        this.students.add(mapperService.studentDtoToStudent(studentDto));
        return "Student added successfully!";
    }
}
