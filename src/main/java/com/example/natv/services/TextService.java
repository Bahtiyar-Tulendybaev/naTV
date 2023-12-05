package com.example.natv.services;

import com.example.natv.models.dto.TextDto;
import com.example.natv.models.entities.Text;

import java.util.List;

public interface TextService {
    TextDto save(TextDto textDto);
    List<Text> findAll();
}
