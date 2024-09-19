package com.YunussEmree.RentACAR.entities.concretes;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "models")
@Data // This annotation is used to create getter and setter methods for the class variables.
@AllArgsConstructor // This annotation is used to create a constructor with parameters.
@NoArgsConstructor
@Getter
@Setter // This annotation is used to create a constructor without parameters.
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This annotation is used to automatically increment the id field.
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "plate")
    private String plate;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "state")
    private int state; //1-Available, 2-Rented, 3-Maintenance

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

}
