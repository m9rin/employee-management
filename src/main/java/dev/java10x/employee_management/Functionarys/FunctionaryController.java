package dev.java10x.employee_management.Functionarys;

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
    public List<FunctionaryDTO> list() {
        return functionaryService.list();
    }

    @GetMapping("/list/{id}")
    public FunctionaryDTO listById(@PathVariable long id) {
        return functionaryService.listById(id);
    }

    @PostMapping("/register")
    public FunctionaryDTO register(@RequestBody FunctionaryDTO functionaryDTO) {
        return functionaryService.register(functionaryDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        functionaryService.delete(id);
        return "Functionary deleted!";
    }

    @PatchMapping("/update/{id}")
    public FunctionaryDTO update(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        return functionaryService.updated(id, fields);
    }
}
