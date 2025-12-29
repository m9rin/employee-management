package dev.java10x.employee_management.Functionarys;

import org.springframework.stereotype.Component;

@Component
public class FunctionaryMapper {

    public FunctionaryModel map(FunctionaryDTO functionaryDTO) {
        FunctionaryModel functionaryModel = new FunctionaryModel();

        functionaryModel.setId(functionaryDTO.getId());
        functionaryModel.setName(functionaryDTO.getName());
        functionaryModel.setCpf(functionaryDTO.getCpf());
        functionaryModel.setEmail(functionaryDTO.getEmail());
        functionaryModel.setPosition(functionaryDTO.getPosition());
        functionaryModel.setSalary(functionaryDTO.getSalary());
        functionaryModel.setDateAdmission(functionaryDTO.getDateAdmission());
        functionaryModel.setActive(functionaryDTO.isActive());
        functionaryModel.setSectors(functionaryDTO.getSectors());

        return functionaryModel;
    }

    public FunctionaryDTO map(FunctionaryModel functionaryModel) {
        FunctionaryDTO functionaryDTO = new FunctionaryDTO();

        functionaryDTO.setId(functionaryModel.getId());
        functionaryDTO.setName(functionaryModel.getName());
        functionaryDTO.setCpf(functionaryModel.getCpf());
        functionaryDTO.setEmail(functionaryModel.getEmail());
        functionaryDTO.setPosition(functionaryModel.getPosition());
        functionaryDTO.setSalary(functionaryModel.getSalary());
        functionaryDTO.setDateAdmission(functionaryModel.getDateAdmission());
        functionaryDTO.setActive(functionaryModel.isActive());
        functionaryDTO.setSectors(functionaryModel.getSectors());

        return functionaryDTO;
    }
}
