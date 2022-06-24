package com.erick.user.controllers;

import com.erick.user.dtos.UserDTO;
import com.erick.user.entities.User;
import com.erick.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/find-by-email/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.findByEmail(email));
    }

    @GetMapping("/validate-login")
    public ResponseEntity<Void> validateLogin(@RequestParam String email, @RequestParam String password) {
        service.validateLogin(email, password);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/decrease-amount")
    public ResponseEntity<Void> decreaseAmount(@RequestParam Double value, @RequestParam String userId) {
        service.decreaseAmount(value, userId);
        return ResponseEntity.noContent().build();
    }

}