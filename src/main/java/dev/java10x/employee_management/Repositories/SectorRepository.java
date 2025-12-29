package dev.java10x.employee_management.Repositories;

import dev.java10x.employee_management.Models.SectorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<SectorModel, Long> {
}
