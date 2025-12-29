package dev.java10x.employee_management.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_sectors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "setor")
    private String name;

    @Column(name = "time")
    private String description;

    @OneToMany(mappedBy = "sectors")
    @JsonIgnore
    private List<FunctionaryModel> functionarys;
}
