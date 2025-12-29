package dev.java10x.employee_management.DTOs;

import dev.java10x.employee_management.Models.SectorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionaryDTO {

    private long id;
    private String name;
    private String cpf;
    private String email;
    private String position;
    private BigDecimal salary;
    private LocalDate dateAdmission;
    private boolean active;
    private SectorModel sectors;

}
