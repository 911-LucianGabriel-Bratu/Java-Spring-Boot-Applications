package com.example.CarsApplication.Repository;

import com.example.CarsApplication.Model.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealershipRepository extends JpaRepository<Dealership, Long> {
}
