package com.erick.creditcard.services;

import com.erick.creditcard.clients.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserClient client;

    public void findById(String id) {
        client.findById(id);
    }

}