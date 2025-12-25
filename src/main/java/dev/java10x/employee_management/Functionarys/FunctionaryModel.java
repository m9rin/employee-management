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
    private long id;

    @Column(name = "nome")
    private String name;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    @Column(name = "cargo")
    private String position;

    @Column(name = "salario")
    private BigDecimal salary;

    @Column(name = "data_admissao")
    private LocalDate dateAdmission;

    @Column(name = "ativo")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private SectorModel sectors;
}
