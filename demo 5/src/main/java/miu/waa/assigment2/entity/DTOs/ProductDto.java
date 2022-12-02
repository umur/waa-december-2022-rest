package miu.waa.assigment2.entity.DTOs;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
public class ProductDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;
    private double rating;
    private CategoryDto category;
    private List<ReviewDto> reviewDtoList;

}
