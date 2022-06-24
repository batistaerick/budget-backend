package com.erick.user.services;

import com.erick.user.converters.UserConverter;
import com.erick.user.dtos.UserDTO;
import com.erick.user.entities.User;
import com.erick.user.exceptions.UserException;
import com.erick.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserConverter converter;
    private final PasswordEncoder encoder;

    public User save(UserDTO dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));
        return repository.save(converter.dtoToEntity(dto));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        return repository.findById(id).orElseThrow(() -> new UserException("User not found!"));
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new UserException("User not found!"));
    }

    public void validateLogin(String email, String password) {
        if (!encoder.matches(password, this.findByEmail(email).getPassword())) {
            throw new UserException("Email or Password is invalid, please try again!");
        }
    }

    @Transactional
    public void decreaseAmount(Double value, String userId) {
        User user = this.findById(userId);
        user.setAmount(user.getAmount() - value);

        if (user.getAmount() < 0) {
            throw new UserException("Insufficient account balance!");
        }
        this.save(converter.entityToDTO(user));
    }

}