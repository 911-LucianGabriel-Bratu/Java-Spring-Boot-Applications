package com.example.CarsApplication.Repository;

import com.example.CarsApplication.Model.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic, Long> {
}
