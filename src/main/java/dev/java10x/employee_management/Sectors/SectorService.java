package dev.java10x.employee_management.Sectors;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectorService {

    private SectorRepository sectorRepository;

    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    public List<SectorModel> listSector() {
        return sectorRepository.findAll();
    }

    public SectorModel sectorById(long id) {
        Optional<SectorModel> sectorById = sectorRepository.findById(id);
        return sectorById.orElse(null);
    }
}
