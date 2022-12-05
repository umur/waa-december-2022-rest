package edu.miu.w1d2.dto;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import lombok.Data;

@Data
public class CourseDto{

    private int id;
    private String name;
    private String code;
}
