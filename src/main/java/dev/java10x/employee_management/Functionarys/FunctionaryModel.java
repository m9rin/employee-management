package dev.java10x.employee_management.Functionarys;

import dev.java10x.employee_management.Sectors.SectorModel;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_functionary")
public class FunctionaryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String position;
    private BigDecimal salary;
    private LocalDate dateAdmission;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "sectors_id")
    private SectorModel sectors;

    public FunctionaryModel() {
    }

    public FunctionaryModel(String name, String cpf, String email, String position, LocalDate dateAdmission, boolean active) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.position = position;
        this.dateAdmission = dateAdmission;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getDateAdmission() {
        return dateAdmission;
    }

    public void setDateAdmission(LocalDate dateAdmission) {
        this.dateAdmission = dateAdmission;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
