package com.sokchoys.domain.user.service;

import com.sokchoys.domain.user.dto.CustomOAuth2User;
import com.sokchoys.domain.user.dto.response.GoogleResponse;
import com.sokchoys.domain.user.dto.response.NaverResponse;
import com.sokchoys.domain.user.dto.response.OAuth2Response;
import com.sokchoys.domain.user.entity.User;
import com.sokchoys.domain.user.repository.UserRepository;
import com.sokchoys.global.constant.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println(oAuth2User.getAttributes());

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = null;
        if (registrationId.equals("naver")) {
            oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
        } else if (registrationId.equals("google")) {
            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        } else {
            return null;
        }

        String username = oAuth2Response.getProvider() + " " + oAuth2Response.getProviderId();
        User existData = userRepository.findByUsername(username);

        Role role = Role.ROLE_USER;

        if (existData == null) {

            User user = User.builder()
                .email(oAuth2Response.getEmail())
                .username(username)
                .role(role)
                .build();

            userRepository.save(user);
        } else {

            existData.updateUser(username, oAuth2Response.getEmail());
            role = existData.getRole();

            userRepository.save(existData);
        }

        return new CustomOAuth2User(oAuth2Response, role.toString());
    }
}