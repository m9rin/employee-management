package dev.java10x.employee_management.Sectors;

import dev.java10x.employee_management.Functionarys.FunctionaryModel;
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
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "sectors")
    private List<FunctionaryModel> functionarys;
}
