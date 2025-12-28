package dev.java10x.employee_management.Sectors;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        Optional<SectorModel> sectorById = sectorRepository.findById(id);
        return sectorById.map(sectorMapper::map).orElse(null);
    }

    public SectorDTO register(SectorDTO sectorDTO) {
        SectorModel sector = sectorMapper.map(sectorDTO);
        sector = sectorRepository.save(sector);
        return sectorMapper.map(sector);
    }

    public void delete(long id) {
        sectorRepository.deleteById(id);
    }

    public SectorDTO update(Long id, Map<String, Object> fields) {
        SectorModel sector = sectorRepository.findById(id).orElse(null);

        fields.forEach((field, value) -> {
            switch(field) {
                case "name" -> sector.setName((String) value);
                case "description" -> sector.setDescription((String) value);
            }
        });

        SectorModel updated = sectorRepository.save(sector);
        return sectorMapper.map(updated);
    }
}
