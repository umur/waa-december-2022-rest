package waa.lab2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> courseTaken;
}
