package edu.miu.restdemo.dto;

import edu.miu.restdemo.entity.Course;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {

    private int id;

    private String name;

    private String code;
    public Course toEntity(CourseDto dto){
        Course c = new Course();
        c.setId(dto.getId());
        c.setName(dto.getName());
        c.setCode(dto.getCode());
        return c;
    }

    public CourseDto toDto(Course c){
        CourseDto dto = new CourseDto();
        dto.setId(c.getId());
        dto.setName(c.getName());
        dto.setCode(c.getCode());
        return dto;
    }

}
