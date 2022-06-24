package com.erick.debitcard.converters;

import com.erick.debitcard.dtos.DebitDTO;
import com.erick.debitcard.entities.Debit;
import org.springframework.stereotype.Component;

@Component
public class DebitConverter {

    public Debit dtoToEntity(DebitDTO dto) {
        Debit entity = new Debit();
        entity.setName(dto.getName());
        entity.setValue(dto.getValue());
        entity.setDateTime(dto.getDateTime());
        entity.setUserId(dto.getUserId());
        return entity;
    }

    public DebitDTO entityToDTO(Debit entity) {
        DebitDTO dto = new DebitDTO();
        dto.setName(entity.getName());
        dto.setValue(entity.getValue());
        dto.setDateTime(entity.getDateTime());
        dto.setUserId(entity.getUserId());
        return dto;
    }

}