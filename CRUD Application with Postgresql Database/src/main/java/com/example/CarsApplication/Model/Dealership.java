package com.example.CarsApplication.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Dealership")

public class Dealership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dealershipID;

    @Column(name = "Name")
    private String name;

    @Column(name = "Capacity")
    private int capacity;

    @Column(name = "Address")
    private String address;

    @Column(name = "Reputation")
    private double reputation;

    @Column(name = "HasService")
    private boolean hasService;

    @Column(name = "OffersTradeIn")
    private boolean offersTradeIn;

    @OneToMany(mappedBy = "dealership", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<Car> cars = new ArrayList<>();

}
