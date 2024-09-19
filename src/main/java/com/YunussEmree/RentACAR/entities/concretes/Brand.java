package com.YunussEmree.RentACAR.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "brands")
// This annotation is used to specify the details of the table that will be used to create the table in the database.
@Data // This annotation is used to create getter and setter methods for the class variables.

//@Data = @Getter + @Setter
//Getter
//@Setter

@AllArgsConstructor // This annotation is used to create a constructor with parameters.
@NoArgsConstructor
@Getter
@Setter // This annotation is used to create a constructor without parameters.
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This annotation is used to automatically increment the id field.
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand")
    List<Model> models;

}