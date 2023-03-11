package com.example.CarsApp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carID;

    @Column(name = "CarManufacturer")
    private String carManufacturer;

    @Column(name = "CarModel")
    private String carModel;

    @Column(name = "CarRetailPrice")
    private double carRetailPrice;

    @Column(name = "CarTopSpeed")
    private double carTopSpeed;

    @Column(name = "CarWeight")
    private double carWeight;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dealershipID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Dealership dealership;
}
