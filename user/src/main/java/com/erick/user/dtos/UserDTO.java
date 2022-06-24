package com.erick.user.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {

    private String id;
    private String name;
    private String email;
    private String password;
    private Double amount;
    private Double salary;
    private Double extra;
    private List<Double> expenses;

}