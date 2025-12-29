package dev.java10x.employee_management.Functionarys;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/functionarys")
public class FunctionaryController {

    private FunctionaryService functionaryService;

    public FunctionaryController(FunctionaryService functionaryService) {
        this.functionaryService = functionaryService;
    }

    @GetMapping("/list")
    @Operation(summary = "List all employees", description = "Create a list with all registered employees")
    public ResponseEntity<List<FunctionaryDTO>> list() {
        List<FunctionaryDTO> functionarys = functionaryService.list();
        return ResponseEntity.ok(functionarys);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<FunctionaryDTO> listById(@PathVariable long id) {
        FunctionaryDTO functionary = functionaryService.listById(id);
        return ResponseEntity.ok(functionary);
    }

    @PostMapping("/register")
    public ResponseEntity<FunctionaryDTO> register(@RequestBody FunctionaryDTO functionaryDTO) {
        FunctionaryDTO saved = functionaryService.register(functionaryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
            functionaryService.delete(id);
            return ResponseEntity.noContent().build();
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<FunctionaryDTO> update(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        FunctionaryDTO updated = functionaryService.updated(id, fields);
        return ResponseEntity.ok(updated);
    }
}
