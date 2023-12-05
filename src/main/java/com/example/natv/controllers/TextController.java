package com.example.natv.controllers;

import com.example.natv.models.dto.TextDto;
import com.example.natv.models.entities.Text;
import com.example.natv.services.TextService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/text")
public class TextController {
    private final TextService textService;

    public TextController(TextService textService) {
        this.textService = textService;
    }
    @PostMapping("/save")
    public TextDto save(@RequestBody TextDto textDto) {
        return textService.save(textDto);
    }
    @GetMapping("/findAll")
    public List<Text> findAll(){
        return textService.findAll();
    }
}
