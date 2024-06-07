package com.example.hotspot_local.service;

import com.example.hotspot_local.controller.response.OAuth.GoogleReponse;
import com.example.hotspot_local.controller.response.OAuth.OAuth2Response;
import com.example.hotspot_local.domain.UserEntity;
import com.example.hotspot_local.dto.CustomOAuth2User;
import com.example.hotspot_local.repository.OAuthRepository;
import com.example.hotspot_local.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

	private final OAuthRepository oAuthRepository;

//	public CustomOAuth2UserService(OAuthRepository oAuthRepository) {
//		this.oAuthRepository = oAuthRepository;
//	}


	private final HttpSession session;

//	public CustomOAuth2UserService(HttpSession session) {
//		this.session = session;
//	}

//	@Override
//	public OAuth2User loadUser(OAuth2UserRequest userRequest) {
//		OAuth2User oAuth2User = super.loadUser(userRequest);
//		String email = oAuth2User.getAttribute("email");
//		session.setAttribute("email", email);
//		return oAuth2User;
//	}

	@Override
	public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {

		OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
//		System.out.println(oAuth2User.getAttributes());    // 여기에서는 값이 들어있는거네!
		String email = oAuth2User.getAttribute("email");
		session.setAttribute("email", email);

		String registrationId = oAuth2UserRequest.getClientRegistration().getRegistrationId();
		OAuth2Response oAuth2Response = null;

		if (registrationId.equals("google")) {
			oAuth2Response = new GoogleReponse(oAuth2User.getAttributes());
		}
		else {
			return null;
		}

		String role = "ROLE_USER";

		UserEntity existData = oAuthRepository.findByUsername(oAuth2Response.getName());

		if (existData == null) {

			UserEntity userEntity = new UserEntity();
			userEntity.setUsername(oAuth2Response.getName());
			userEntity.setEmail(oAuth2Response.getEmail());
			userEntity.setRole(role);


			oAuthRepository.save(userEntity);
		}
		else {

			existData.setUsername(oAuth2Response.getName());
			existData.setEmail(oAuth2Response.getEmail());

			role = existData.getRole();

			oAuthRepository.save(existData);
		}

		return new CustomOAuth2User(oAuth2Response, role);

	}
}