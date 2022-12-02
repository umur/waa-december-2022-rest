package miu.waa.assigment2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;

    @ManyToOne
    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinTable(name= "Userdata_review",
            joinColumns =@JoinColumn(name = "userdata_id"),
            inverseJoinColumns = @JoinColumn(name = "review_id")
    )
    private Userdata userdata;


}
