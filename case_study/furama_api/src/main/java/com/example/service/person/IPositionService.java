package com.example.service.person;

import com.example.model.person.Position;
import com.example.service.IFuramaService;

import java.util.List;

public interface IPositionService extends IFuramaService<Position> {
    List<Position> findAll();
}
