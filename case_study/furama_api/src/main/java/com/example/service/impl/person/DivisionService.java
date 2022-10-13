package com.example.service.impl.person;

import com.example.model.person.Division;
import com.example.repository.person.IDivisionRepository;
import com.example.service.person.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {

    @Autowired
    private IDivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Division findById(int id) {
        return divisionRepository.findById(id).orElse(null);
    }

    @Override
    public Division insert(Division element) {
        return divisionRepository.save(element);
    }

    @Override
    public Division update(Division element) {
        return divisionRepository.save(element);
    }

    @Override
    public boolean delete(int id) {
        return divisionRepository.deleteLogicById(id);
    }
}
