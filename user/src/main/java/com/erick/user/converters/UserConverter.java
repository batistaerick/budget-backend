package com.erick.user.converters;

import com.erick.user.dtos.UserDTO;
import com.erick.user.entities.User;
import com.erick.user.exceptions.UserException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDTO entityToDTO(User entity) {
        try {
            UserDTO dto = new UserDTO();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        } catch (BeansException e) {
            throw new UserException(e);
        }
    }

    public User dtoToEntity(UserDTO dto) {
        try {
            User entity = new User();
            BeanUtils.copyProperties(dto, entity);
            return entity;
        } catch (BeansException e) {
            throw new UserException(e);
        }
    }

}