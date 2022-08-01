package com.erick.creditcard.converters;

import com.erick.creditcard.dtos.CreditDTO;
import com.erick.creditcard.entities.Credit;
import org.springframework.stereotype.Component;

@Component
public class CreditConverter {

    public Credit dtoToEntity(CreditDTO dto) {
        Credit entity = new Credit();
        entity.setName(dto.getName());
        entity.setAmount(dto.getAmount());
        entity.setInstallment(dto.getInstallment());
        entity.setInstallmentValue(dto.getInstallmentValue());
        entity.setDate(dto.getDate());
        entity.setUserId(dto.getUserId());
        return entity;
    }

    public CreditDTO entityToDTO(Credit entity) {
        CreditDTO dto = new CreditDTO();
        dto.setName(entity.getName());
        dto.setAmount(entity.getAmount());
        dto.setInstallment(entity.getInstallment());
        dto.setInstallmentValue(entity.getInstallmentValue());
        dto.setDate(entity.getDate());
        dto.setUserId(entity.getUserId());
        return dto;
    }

}