package dev.java10x.employee_management.Sectors;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorService {

    private SectorRepository sectorRepository;

    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    public List<SectorModel> listSector() {
        return sectorRepository.findAll();
    }
}
