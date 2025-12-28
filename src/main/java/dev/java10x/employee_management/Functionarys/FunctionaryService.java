package dev.java10x.employee_management.Functionarys;

import dev.java10x.employee_management.Sectors.SectorModel;
import dev.java10x.employee_management.Sectors.SectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FunctionaryService {

    private FunctionaryRepository functionaryRepository;
    private SectorRepository sectorRepository;

    public FunctionaryService(FunctionaryRepository functionaryRepository, SectorRepository sectorRepository) {
        this.functionaryRepository = functionaryRepository;
        this.sectorRepository = sectorRepository;
    }

    public List<FunctionaryModel> list() {
        return functionaryRepository.findAll();
    }

    public FunctionaryModel listById(long id) {
        Optional<FunctionaryModel> functionaryById = functionaryRepository.findById(id);
        return functionaryById.orElse(null);
    }

    public FunctionaryModel register(FunctionaryModel functionary) {
        return functionaryRepository.save(functionary);
    }

    public void delete(long id) {
        functionaryRepository.deleteById(id);
    }

    public FunctionaryModel updated(Long id, Map<String, Object> fields) {
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
        return functionaryRepository.save(functionary);
    }
}
