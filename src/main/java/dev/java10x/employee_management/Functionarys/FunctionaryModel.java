package dev.java10x.employee_management.Functionarys;

import dev.java10x.employee_management.Sectors.SectorModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_functionary")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FunctionaryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;
    private String position;
    private BigDecimal salary;
    private LocalDate dateAdmission;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "sectors_id")
    private SectorModel sectors;
}
