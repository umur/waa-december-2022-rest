package edu.miu.w1d2.entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Course {

    private int id;
    private String name;
    private String code;
    private boolean isDelete;

    public Course(int i, String name,String code, boolean b) {
        this.id = i;
        this.name = name;
        this.code = code;
        this.isDelete = b;
    }
}
