package MIU.edu.studentsrestapi.repositories;

import MIU.edu.studentsrestapi.dtos.CourseDto;
import MIU.edu.studentsrestapi.entities.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class CourseRepository {
    private List<Course> courses;

    public CourseRepository() {
        Course course1 = new Course(1, "FPP", "CS390");
        Course course2 = new Course(2, "MPP", "CS401");
        Course course3 = new Course(3, "MWA", "CS572");
        Course course4 = new Course(4, "WAA", "CS545");
        Course course5 = new Course(5, "ECO", "MBA101");
        Course course6 = new Course(6, "FIN", "MBA102");
        Course course7 = new Course(7, "DAT", "MBA103");
        Course course8 = new Course(8, "LIB", "MBA104");
        this.courses = new ArrayList<>(){{add(course1); add(course2); add(course3); add(course4); add(course5); add(course6); add(course7); add(course8); }};
    }

    private int getRandom() {
        Random rand = new Random();
        return rand.nextInt(100);
    }
    public List<CourseDto> getCourses() {
        List<CourseDto> courses= new ArrayList<>();
        for(Course course: this.courses) {
            courses.add(courseToCourseDto(course));
        }
        return courses;
    }

    public CourseDto getCourse(int courseId) {
        for(Course course : this.courses) {
            if(course.getId() == courseId) {
                return courseToCourseDto(course);
            }
        }
        return null;
    }

    public String addCourse(CourseDto cc) {
        this.courses.add(courseDtoToCourse(cc));
        return "Course added Successfully!";
    }

    public String deleteCourse(int courseId) {
        int pos = -1;
        for(int i = 0; i < this.courses.size(); i++) {
            if(this.courses.get(i).getId() == courseId) {
                pos = i;
            }
        }
        if(pos == -1) {
            return "Course with given courseId not found!";
        } else {
            this.courses.remove(pos);
            return "Course with given courseId deleted successfully!";
        }
    }

    public String updateCourse(int courseId, CourseDto courseDto) {
        boolean updateFlag = false;
        for(Course course: this.courses) {
            if(course.getId() == courseId) {
                updateFlag = true;
                course.setCode(courseDto.getCode());
                course.setName(courseDto.getName());
            }
        }
        if(!updateFlag) {
            return "Course with given courseId not found!";
        } else {
            return "Course with given courseId updated successfully!";
        }
    }

    public Course courseDtoToCourse(CourseDto courseDto) {
        Course cc = new Course();
        cc.setCode(courseDto.getCode());
        cc.setName(courseDto.getName());
        cc.setId(getRandom());
        return cc;
    }

    public CourseDto courseToCourseDto(Course course) {
        CourseDto cc = new CourseDto();
        cc.setCode(course.getCode());
        cc.setName(course.getName());
        cc.setId(course.getId());
        return cc;
    }
}
