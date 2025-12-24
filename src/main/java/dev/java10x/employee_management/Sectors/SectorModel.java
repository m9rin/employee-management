package dev.java10x.employee_management.Sectors;

import dev.java10x.employee_management.Functionarys.FunctionaryModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_sectors")
public class SectorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "sectors")
    private List<FunctionaryModel> functionarys;

    public SectorModel() {
    }

    public SectorModel(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
