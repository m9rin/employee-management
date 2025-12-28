package dev.java10x.employee_management.Sectors;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SectorService {

    private SectorRepository sectorRepository;

    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    public List<SectorModel> list() {
        return sectorRepository.findAll();
    }

    public SectorModel listById(long id) {
        Optional<SectorModel> sectorById = sectorRepository.findById(id);
        return sectorById.orElse(null);
    }

    public SectorModel register(SectorModel sector) {
        return sectorRepository.save(sector);
    }

    public void delete(long id) {
        sectorRepository.deleteById(id);
    }

    public SectorModel update(Long id, Map<String, Object> fields) {
        SectorModel sector = sectorRepository.findById(id).orElse(null);

        fields.forEach((field, value) -> {
            switch(field) {
                case "name" -> sector.setName((String) value);
                case "description" -> sector.setDescription((String) value);
            }
        });
        return sectorRepository.save(sector);
    }
}
