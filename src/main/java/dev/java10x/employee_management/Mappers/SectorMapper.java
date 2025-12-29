package dev.java10x.employee_management.Sectors;

import org.springframework.stereotype.Component;

@Component
public class SectorMapper {

    public SectorModel map(SectorDTO sectorDTO) {
        SectorModel sectorModel = new SectorModel();

        sectorModel.setId(sectorDTO.getId());
        sectorModel.setName(sectorDTO.getName());
        sectorModel.setDescription(sectorDTO.getDescription());
        sectorModel.setFunctionarys(sectorDTO.getFunctionarys());

        return sectorModel;
    }

    public SectorDTO map(SectorModel sectorModel) {
        SectorDTO sectorDTO = new SectorDTO();

        sectorDTO.setId(sectorModel.getId());
        sectorDTO.setName(sectorModel.getName());
        sectorDTO.setDescription(sectorModel.getDescription());
        sectorDTO.setFunctionarys(sectorModel.getFunctionarys());

        return sectorDTO;
    }
}
