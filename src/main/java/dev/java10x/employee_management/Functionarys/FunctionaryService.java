package dev.java10x.employee_management.Functionarys;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FunctionaryService {

    private FunctionaryRepository functionaryRepository;

    public FunctionaryService(FunctionaryRepository functionaryRepository) {
        this.functionaryRepository = functionaryRepository;
    }

    public List<FunctionaryModel> listFunctionary() {
        return functionaryRepository.findAll();
    }

    public FunctionaryModel functionaryById(long id) {
        Optional<FunctionaryModel> functionaryById = functionaryRepository.findById(id);
        return functionaryById.orElse(null);

    }
}
