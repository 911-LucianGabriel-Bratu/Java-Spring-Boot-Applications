package com.example.CarsApp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Mechanics")
public class Mechanic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mechanicID;

    @Column(name = "Name")
    private String name;

    @Column(name = "CNP")
    private String cnp;

    @Column(name = "Address")
    private String address;

    @Column(name = "Experience")
    private int experience;

    @Column(name = "FavouriteCarBrand")
    private String favouriteCarBrand;
}
