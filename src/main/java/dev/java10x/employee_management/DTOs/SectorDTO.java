package dev.java10x.employee_management.DTOs;

import dev.java10x.employee_management.Models.FunctionaryModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectorDTO {

    private long id;
    private String name;
    private String description;
    private List<FunctionaryModel> functionarys;

}
