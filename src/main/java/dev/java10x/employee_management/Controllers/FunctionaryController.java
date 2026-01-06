package dev.java10x.employee_management.Controllers;

import dev.java10x.employee_management.DTOs.FunctionaryDTO;
import dev.java10x.employee_management.Services.FunctionaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/functionarys")
public class FunctionaryController {

    private final FunctionaryService functionaryService;

    public FunctionaryController(FunctionaryService functionaryService) {
        this.functionaryService = functionaryService;
    }

    @GetMapping("/list")
    @Operation(summary = "List all employees", description = "Create a list with all registered employees")
    @ApiResponse(responseCode = "200", description = "Return a list of all registered employees in JSON format")
    public ResponseEntity<List<FunctionaryDTO>> list() {
        List<FunctionaryDTO> functionarys = functionaryService.list();
        return ResponseEntity.ok(functionarys);
    }

    @GetMapping("/list/{id}")
    @Operation(summary = "Lists the employee by ID", description = "Lists the employee whose ID was passed as a parameter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return employee whose ID was passed as a parameter"),
            @ApiResponse(responseCode = "404", description = "Return not found if the ID does not exists")
    })
    public ResponseEntity<FunctionaryDTO> listById(@PathVariable long id) {
        FunctionaryDTO functionary = functionaryService.listById(id);
        return ResponseEntity.ok(functionary);
    }

    @PostMapping("/register")
    @Operation(summary = "Register an employee", description = "Register an employee and assign it to a sector")
    @ApiResponse(responseCode = "201", description = "Returns the registered employee with all their data in JSON format")
    public ResponseEntity<FunctionaryDTO> register(@RequestBody FunctionaryDTO functionaryDTO) {
        FunctionaryDTO saved = functionaryService.register(functionaryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete by ID", description = "Deleted the employee whose ID was passed as a parameter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "No return in the body"),
            @ApiResponse(responseCode = "404", description = "Return not found if the ID does not exists")
    })
    public ResponseEntity<Void> delete(@PathVariable long id) {
            functionaryService.delete(id);
            return ResponseEntity.noContent().build();
    }

    @PatchMapping("/update/{id}")
    @Operation(summary = "Update fields", description = "Updates permitted fields according to company needs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated sucessfully"),
            @ApiResponse(responseCode = "400", description = "Error regarding the type of data passed or data is not allowed for partial update"),
            @ApiResponse(responseCode = "404", description = "ID not found"),
            @ApiResponse(responseCode = "500", description = "Attempt to rewrite unique data")
    })
    public ResponseEntity<FunctionaryDTO> update(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        FunctionaryDTO updated = functionaryService.updated(id, fields);
        return ResponseEntity.ok(updated);
    }
}
