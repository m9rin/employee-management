package dev.java10x.employee_management.Sectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SectorController {

    @GetMapping("/sector")
    public String sector() {
        return "Test, Test, Testing!";
    }
}
