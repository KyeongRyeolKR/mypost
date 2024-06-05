package com.example.mypost.domain.user.entity;

import com.example.mypost.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class User extends BaseEntity {

    private String kakaoId;
    private String nickname;
    private String role;
}
