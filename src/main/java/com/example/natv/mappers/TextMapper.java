package com.example.natv.mappers;

import com.example.natv.models.dto.TextDto;
import com.example.natv.models.entities.Text;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TextMapper {
    TextMapper INSTANCE = Mappers.getMapper(TextMapper.class);
    TextDto textToTextDto(Text text);
    @InheritInverseConfiguration
    Text textDtoToText(TextDto textDto);
}
