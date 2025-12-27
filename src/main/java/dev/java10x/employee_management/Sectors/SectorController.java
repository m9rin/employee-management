package dev.java10x.employee_management.Sectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sectors")
public class SectorController {

    private SectorService sectorService;

    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @GetMapping("/sector")
    public String sector() {
        return "Test, Test, Testing!";
    }

    @GetMapping("/list")
    public List<SectorModel> listSector() {
        return sectorService.listSector();
    }
}
