package com.example.CarsApplication.Repository;

import com.example.CarsApplication.Model.PerformsMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<PerformsMaintenance, Long> {
}
