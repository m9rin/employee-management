package dev.java10x.employee_management.Functionarys;

import dev.java10x.employee_management.Sectors.SectorModel;
import dev.java10x.employee_management.Sectors.SectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        Optional<FunctionaryModel> functionaryById = functionaryRepository.findById(id);
        return functionaryById.map(functionaryMapper::map).orElse(null);
    }

    public FunctionaryDTO register(FunctionaryDTO functionaryDTO)
    {
        FunctionaryModel functionary = functionaryMapper.map(functionaryDTO);
        functionary = functionaryRepository.save(functionary);
        return functionaryMapper.map(functionary);
    }

    public void delete(long id) {
        functionaryRepository.deleteById(id);
    }

    public FunctionaryDTO updated(Long id, Map<String, Object> fields) {
        FunctionaryModel functionary = functionaryRepository.findById(id).orElse(null);

        fields.forEach((field, value) -> {
            switch (field) {
                case "name" -> functionary.setName((String) value);
                case "cpf" -> functionary.setCpf((String) value);
                case "email" -> functionary.setEmail((String) value);
                case "position" -> functionary.setPosition((String) value);
                case "salary" -> functionary.setSalary(new java.math.BigDecimal(value.toString()));
                case "dateAdmission" -> functionary.setDateAdmission(java.time.LocalDate.parse((String) value));
                case "active" -> functionary.setActive((Boolean) value);
                case "sectorId" -> {
                    Long sectorId = ((Number) value).longValue();
                    SectorModel sector = sectorRepository.findById(sectorId).orElse(null);
                    functionary.setSectors(sector);
                }
            }
        });

        FunctionaryModel updated = functionaryRepository.save(functionary);
        return functionaryMapper.map(updated);
    }
}
