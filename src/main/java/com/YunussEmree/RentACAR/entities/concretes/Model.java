package com.YunussEmree.RentACAR.entities.concretes;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "models")
@Data // This annotation is used to create getter and setter methods for the class variables.
@AllArgsConstructor // This annotation is used to create a constructor with parameters.
@NoArgsConstructor
@Getter
@Setter // This annotation is used to create a constructor without parameters.
@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This annotation is used to automatically increment the id field.
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;


}
