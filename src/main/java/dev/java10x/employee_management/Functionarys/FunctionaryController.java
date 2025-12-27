package dev.java10x.employee_management.Functionarys;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/functionarys")
public class FunctionaryController {

    private FunctionaryService functionaryService;

    public FunctionaryController(FunctionaryService functionaryService) {
        this.functionaryService = functionaryService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "Test Test Test";
    }

    @GetMapping("/list")
    public List<FunctionaryModel> listFunctionary() {
        return functionaryService.listFunctionary();
    }

    @GetMapping("/list/{id}")
    public FunctionaryModel functionaryById(@PathVariable long id) {
        return functionaryService.functionaryById(id);
    }
}
