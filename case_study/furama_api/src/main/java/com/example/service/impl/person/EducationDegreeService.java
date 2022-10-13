package com.example.service.impl.person;

import com.example.model.person.EducationDegree;
import com.example.repository.person.IEducationDegreeRepository;
import com.example.service.person.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {

    @Autowired
    private IEducationDegreeRepository degreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return degreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(int id) {
        return degreeRepository.findById(id).orElse(null);
    }

    @Override
    public EducationDegree insert(EducationDegree element) {
        return degreeRepository.save(element);
    }

    @Override
    public EducationDegree update(EducationDegree element) {
        return degreeRepository.save(element);
    }

    @Override
    public boolean delete(int id) {
        return degreeRepository.deleteLogicById(id);
    }
}
