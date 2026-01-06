package dev.java10x.employee_management.Controllers;

import dev.java10x.employee_management.DTOs.SectorDTO;
import dev.java10x.employee_management.Services.SectorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sectors")
public class SectorController {

    private final SectorService sectorService;

    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @GetMapping("/list")
    @Operation(summary = "List all Sectors", description = "Create a list with all registered sectors")
    @ApiResponse(responseCode = "200", description = "Return a list of all registered sectors in JSON format")
    public ResponseEntity<List<SectorDTO>> list() {
        List<SectorDTO> sectors = sectorService.list();
        return ResponseEntity.ok(sectors);
    }

    @GetMapping("/list/{id}")
    @Operation(summary = "Lists the sector by ID", description = "Lists the sector whose ID was passed as a parameter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return sector whose ID was passed as a parameter"),
            @ApiResponse(responseCode = "404", description = "Return not found if the ID does not exists")
    })
    public ResponseEntity<SectorDTO> listById(@PathVariable long id) {
        SectorDTO sector = sectorService.listById(id);
        return ResponseEntity.ok(sector);
    }

    @PostMapping("/register")
    @Operation(summary = "Create an sector", description = "Create an sector")
    @ApiResponse(responseCode = "201", description = "Returns the sector created with all their data in JSON format")
    public ResponseEntity<SectorDTO> register(@RequestBody SectorDTO sectorDTO) {
        SectorDTO saved = sectorService.register(sectorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete by ID", description = "Deleted the sector whose ID was passed as a parameter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "No return in the body"),
            @ApiResponse(responseCode = "404", description = "Return not found if the ID does not exists")
    })
    public ResponseEntity<Void> delete(@PathVariable long id) {
       sectorService.delete(id);
       return ResponseEntity.noContent().build();
    }

    @PatchMapping("/update/{id}")
    @Operation(summary = "Update fields", description = "Updates permitted fields according to company needs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated sucessfully"),
            @ApiResponse(responseCode = "400", description = "Error regarding the type of data passed or data is not allowed for partial update"),
            @ApiResponse(responseCode = "404", description = "ID not found"),
            @ApiResponse(responseCode = "500", description = "Attempt to pass data that does not exist")
    })
    public ResponseEntity<String> sectorUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        if (sectorService.listById(id) != null) {
            sectorService.update(id, fields);
            return ResponseEntity.ok("Updated id:" + id + " Fields: " + fields);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sector not found!");
        }
    }
}
