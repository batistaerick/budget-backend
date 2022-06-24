package com.erick.creditcard.converters;

import com.erick.creditcard.dtos.CreditDTO;
import com.erick.creditcard.entities.Credit;
import org.springframework.stereotype.Component;

@Component
public class CreditConverter {

    public Credit dtoToEntity(CreditDTO dto) {
        Credit entity = new Credit();
        entity.setName(dto.getName());
        entity.setValue(dto.getValue());
        entity.setDateTime(dto.getDateTime());
        entity.setInstallment(dto.getInstallment());
        entity.setUserId(dto.getUserId());
        return entity;
    }

    public CreditDTO entityToDTO(Credit entity) {
        CreditDTO dto = new CreditDTO();
        dto.setName(entity.getName());
        dto.setValue(entity.getValue());
        dto.setDateTime(entity.getDateTime());
        dto.setInstallment(entity.getInstallment());
        dto.setUserId(entity.getUserId());
        return dto;
    }

}