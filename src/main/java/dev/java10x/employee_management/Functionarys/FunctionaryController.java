package dev.java10x.employee_management.Functionarys;

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
    public ResponseEntity<List<FunctionaryDTO>> list() {
        List<FunctionaryDTO> functionarys = functionaryService.list();
        return ResponseEntity.ok(functionarys);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> listById(@PathVariable long id) {
        FunctionaryDTO functionary = functionaryService.listById(id);
        if (functionary != null) {
            return ResponseEntity.ok(functionary);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found!");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody FunctionaryDTO functionaryDTO) {
        FunctionaryDTO functionary = functionaryService.register(functionaryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registered employee " + functionary.getName() + " ID: " + functionary.getId());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        if (functionaryService.listById(id) != null) {
            functionaryService.delete(id);
            return ResponseEntity.ok("Deleted employee: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found!");
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        if (functionaryService.listById(id) != null) {
            functionaryService.updated(id, fields);
            return ResponseEntity.ok("Updated id: " + id + " Fields: " + fields);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found!");
        }
    }
}
