package dev.java10x.employee_management.Sectors;

import dev.java10x.employee_management.Functionarys.FunctionaryModel;
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
