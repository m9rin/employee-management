package dev.java10x.employee_management.Repositories;

import dev.java10x.employee_management.Models.FunctionaryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FunctionaryRepository extends JpaRepository<FunctionaryModel, Long> {
}
