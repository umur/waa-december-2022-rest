package edu.miu.restdemo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class Review {

    private int id;

    private String comment;



}
