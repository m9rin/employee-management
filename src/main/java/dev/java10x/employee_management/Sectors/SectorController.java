package dev.java10x.employee_management.Sectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<SectorDTO>> list() {
        List<SectorDTO> sectors = sectorService.list();
        return ResponseEntity.ok(sectors);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> listById(@PathVariable long id) {
        SectorDTO sector = sectorService.listById(id);
        if(sector != null) {
            return ResponseEntity.ok(sector);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sector not found!");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody SectorDTO sectorDTO) {
        SectorDTO sector = sectorService.register(sectorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registed sector: " + sector.getName() + sector.getDescription() + " ID: " + sector.getId());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        if (sectorService.listById(id) != null) {
            sectorService.delete(id);
            return ResponseEntity.ok("Sector id: " + id + " deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sector not found!");
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> sectorUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        if (sectorService.listById(id) != null) {
            sectorService.update(id, fields);
            return ResponseEntity.ok("Updated id:" + id + " Fields: " + fields);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sector not found!");
        }
    }
}
