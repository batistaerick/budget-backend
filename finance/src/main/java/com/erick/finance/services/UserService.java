package com.erick.finance.services;

import com.erick.finance.clients.UserClient;
import com.erick.finance.dtos.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserClient client;

    public UserDTO findById(String id) {
        return client.findById(id);
    }

}