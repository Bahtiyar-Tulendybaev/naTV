package com.example.natv.services.impl;

import com.example.natv.mappers.TextMapper;
import com.example.natv.models.dto.TextDto;
import com.example.natv.models.entities.Text;
import com.example.natv.repository.TextRepo;
import com.example.natv.services.TextService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextServiceImpl implements TextService {
    private final TextRepo textRepo;
    public TextServiceImpl(TextRepo textRepo) {
        this.textRepo = textRepo;
    }
    @Override
    public TextDto save(TextDto textDto) {
        Text text = TextMapper.INSTANCE.textDtoToText(textDto);
        text.setSymbolCount(textDto.getText().replaceAll(" ", "").length());
        text = textRepo.save(text);
        textDto.setId(text.getId());
        textDto.setSymbolCount(text.getSymbolCount());
        return textDto;
    }
    @Override
    public List<Text> findAll() {
        return textRepo.findAll();
    }
}
