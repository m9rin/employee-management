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
    public List<FunctionaryModel> listFunctionary() {
        return functionaryService.listFunctionary();
    }

    @GetMapping("/list/{id}")
    public FunctionaryModel functionaryById(@PathVariable long id) {
        return functionaryService.functionaryById(id);
    }

    @PostMapping("/register")
    public FunctionaryModel register(@RequestBody FunctionaryModel functionary) {
        return functionaryService.register(functionary);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        functionaryService.delete(id);
        return "Functionary deleted!";
    }

    @PatchMapping("/update/{id}")
    public FunctionaryModel update(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        return functionaryService.updated(id, fields);
    }
}
