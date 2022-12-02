package miu.waa.assigment2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private int id;
    private String street;
    private String zip;
    private String city;
//    @OneToOne(mappedBy = "address")
//    private User user;
}
