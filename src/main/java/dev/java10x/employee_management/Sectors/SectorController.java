package dev.java10x.employee_management.Sectors;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sectors")
public class SectorController {

    private SectorService sectorService;

    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @GetMapping("/list")
    public List<SectorModel> listSector() {
        return sectorService.listSector();
    }

    @GetMapping("/list/{id}")
    public SectorModel sectorById(@PathVariable long id) {
        return sectorService.sectorById(id);
    }

    @PostMapping("/register")
    public SectorModel sectorRegister(@RequestBody SectorModel sector) {
        return sectorService.sectorRegister(sector);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        sectorService.delete(id);
        return "Sector deleted!";
    }
}
