package com.mavila.pos.service.user;

import com.mavila.pos.dto.request.UserRequestDTO;
import com.mavila.pos.dto.response.UserResponseDTO;
import com.mavila.pos.entity.user.User;
import com.mavila.pos.mapper.UserMapper;
import com.mavila.pos.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository repository;

    @Autowired
    private final UserMapper mapper;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserResponseDTO create(UserRequestDTO dto) {

        if (repository.existsByUsername(dto.username())) {
            throw new RuntimeException("Username already exists");
        }

        User user = mapper.toEntity(dto);

        user.setPassword(passwordEncoder.encode(dto.password()));

        User saved = repository.save(user);

        return mapper.toResponse(saved);
    }

    public List<UserResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

}
