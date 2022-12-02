package miu.waa.assigment2.entity.DTOs;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;



@Data
public class ReviewDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;

    @JsonIgnore
    private UserDto user;
    @JsonIgnore
    private ProductDto product;

}
