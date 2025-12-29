package dev.java10x.employee_management.Services;

import dev.java10x.employee_management.DTOs.SectorDTO;
import dev.java10x.employee_management.Mappers.SectorMapper;
import dev.java10x.employee_management.Models.SectorModel;
import dev.java10x.employee_management.Repositories.SectorRepository;
import dev.java10x.employee_management.Common.Exceptions.BusinessException;
import dev.java10x.employee_management.Common.Exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SectorService {

    private SectorRepository sectorRepository;
    private SectorMapper sectorMapper;

    public SectorService(SectorRepository sectorRepository, SectorMapper sectorMapper) {
        this.sectorRepository = sectorRepository;
        this.sectorMapper = sectorMapper;
    }

    public List<SectorDTO> list() {
        List<SectorModel> sectors = sectorRepository.findAll();
        return sectors.stream()
                .map(sectorMapper::map)
                .collect(Collectors.toList());
    }

    public SectorDTO listById(long id) {
        SectorModel sectorById = sectorRepository.findById(id).orElseThrow(() -> new RuntimeException("Sector not found to id: " + id));
        return sectorMapper.map(sectorById);
    }

    public SectorDTO register(SectorDTO sectorDTO) {
        SectorModel sector = sectorMapper.map(sectorDTO);
        sector = sectorRepository.save(sector);
        return sectorMapper.map(sector);
    }

    public void delete(long id) {
        if (!sectorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Sector not found to id: " + id);
        }
        sectorRepository.deleteById(id);
    }

    public SectorDTO update(Long id, Map<String, Object> fields) {
        SectorModel sector = sectorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sector not found to id: " + id));

        try {
            partialUpdate(sector, fields);
        } catch (ClassCastException exception) {
            throw new BusinessException("Updated to the sector failed: " + exception.getMessage());
        }

        SectorModel updated = sectorRepository.save(sector);
        return sectorMapper.map(updated);
    }

    private void partialUpdate(SectorModel sector, Map<String, Object> fields) {
        for (Map.Entry<String, Object> entry : fields.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();

            switch (field) {
                case "name" -> sector.setName((String) value);
                case "description" -> sector.setDescription((String) value);
                default -> throw new BusinessException("Field: " + field + " is not allowed for partial update.");
            }
        }
    }
}
