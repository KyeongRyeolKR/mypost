package com.example.mypost.domain.user.service;

import com.example.mypost.domain.user.entity.User;
import com.example.mypost.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User create(String id, String name) {
        User newUser = User.builder()
                .kakaoId(id)
                .nickname(name)
                .role("ROLE_USER")
                .build();

        return userRepository.save(newUser);
    }

    public Optional<User> findByKakaoId(String kakaoId) {
        return userRepository.findByKakaoId(kakaoId);
    }
}
