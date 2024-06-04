package com.example.mypost.global.auth;

import com.example.mypost.domain.user.entity.User;
import com.example.mypost.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserService userService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        OAuth2Attributes attributes = OAuth2Attributes.of("kakao", oAuth2User.getAttributes());

        User user = userService.findByKakaoId(attributes.getId())
                .orElseGet(() -> userService.create(attributes.getId(), attributes.getName()));

        return new DefaultOAuth2User(List.of(new SimpleGrantedAuthority(user.getRole())), attributes.getAttributes(), attributes.getNameAttributeKey());
    }
}
