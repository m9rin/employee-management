package dev.java10x.employee_management.Services;

import dev.java10x.employee_management.DTOs.FunctionaryDTO;
import dev.java10x.employee_management.Mappers.FunctionaryMapper;
import dev.java10x.employee_management.Models.FunctionaryModel;
import dev.java10x.employee_management.Repositories.FunctionaryRepository;
import dev.java10x.employee_management.Models.SectorModel;
import dev.java10x.employee_management.Repositories.SectorRepository;
import dev.java10x.employee_management.Common.Exceptions.BusinessException;
import dev.java10x.employee_management.Common.Exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FunctionaryService {

    private FunctionaryRepository functionaryRepository;
    private FunctionaryMapper functionaryMapper;
    private SectorRepository sectorRepository;

    public FunctionaryService(FunctionaryRepository functionaryRepository, FunctionaryMapper functionaryMapper, SectorRepository sectorRepository) {
        this.functionaryRepository = functionaryRepository;
        this.functionaryMapper = functionaryMapper;
        this.sectorRepository = sectorRepository;
    }

    public List<FunctionaryDTO> list() {
        List<FunctionaryModel> functionarys = functionaryRepository.findAll();
        return functionarys.stream()
                .map(functionaryMapper::map)
                .collect(Collectors.toList());
    }

    public FunctionaryDTO listById(long id) {
        FunctionaryModel functionaryById = functionaryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found to id: " + id));
        return functionaryMapper.map(functionaryById);
    }

    public FunctionaryDTO register(FunctionaryDTO functionaryDTO) {
        FunctionaryModel functionary = functionaryMapper.map(functionaryDTO);
        functionary = functionaryRepository.save(functionary);
        return functionaryMapper.map(functionary);
    }

    public void delete(long id) {
        if (!functionaryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found to id: " + id);
        }
        functionaryRepository.deleteById(id);
    }

    public FunctionaryDTO updated(Long id, Map<String, Object> fields) {
        FunctionaryModel functionary = functionaryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found to id: " + id));

        try {
            partialUpdate(functionary, fields);
        } catch (DateTimeParseException | NumberFormatException | ClassCastException exception) {
            throw new BusinessException("Updated to the employee failed: " + exception.getMessage());
        }

        FunctionaryModel updated = functionaryRepository.save(functionary);
        return functionaryMapper.map(updated);
    }

    private void partialUpdate(FunctionaryModel functionary, Map<String, Object> fields) {
        for (Map.Entry<String, Object> entry : fields.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();

            switch (field) {
                case "name" -> functionary.setName((String) value);
                case "email" -> functionary.setEmail((String) value);
                case "position" -> functionary.setPosition((String) value);
                case "salary" -> {
                    BigDecimal salary = new BigDecimal(value.toString());
                    functionary.setSalary(salary);
                }
                case "dateAdmission" -> {
                    LocalDate date = LocalDate.parse(value.toString());
                    functionary.setDateAdmission(date);
                }
                case "active" -> {
                    Boolean active = (value instanceof Boolean) ? (Boolean) value : Boolean.valueOf(value.toString());
                    functionary.setActive(active);
                }
                case "sectorId" -> {
                    Long sectorId;
                    if (value instanceof Number number) {
                        sectorId = number.longValue();
                    } else {
                        sectorId = Long.valueOf(value.toString());
                    }

                    SectorModel sector = sectorRepository.findById(sectorId).orElseThrow(() -> new ResourceNotFoundException("Sector not found to id: " + sectorId));

                    functionary.setSectors(sector);
                }
                default -> throw new BusinessException("Field: " + field + " is not allowed for partial update.");
            }
        }
    }
}

