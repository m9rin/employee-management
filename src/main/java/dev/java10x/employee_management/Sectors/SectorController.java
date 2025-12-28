package dev.java10x.employee_management.Sectors;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sectors")
public class SectorController {

    private SectorService sectorService;

    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @GetMapping("/list")
    public List<SectorModel> list() {
        return sectorService.list();
    }

    @GetMapping("/list/{id}")
    public SectorModel listById(@PathVariable long id) {
        return sectorService.listById(id);
    }

    @PostMapping("/register")
    public SectorModel register(@RequestBody SectorModel sector) {
        return sectorService.register(sector);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        sectorService.delete(id);
        return "Sector deleted!";
    }

    @PatchMapping("/update/{id}")
    public SectorModel sectorUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        return sectorService.update(id, fields);
    }
}
