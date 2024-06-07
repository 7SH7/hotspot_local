package com.example.hotspot_local.dto;


import com.example.hotspot_local.controller.response.OAuth.OAuth2Response;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class CustomOAuth2User implements OAuth2User {

	private final OAuth2Response oAuth2Response;
	private final String role;

	public CustomOAuth2User(OAuth2Response oAuth2Response, String role) {

		this.oAuth2Response = oAuth2Response;
		this.role = role;
	}

	public Map<String, Object> getAttributes() {

		return null;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> collection = new ArrayList<>();

		collection.add(new GrantedAuthority() {

			@Override
			public String getAuthority() {

				return role;
			}
		});

		return collection;
	}

	public String getName() {

		return oAuth2Response.getName();
	}

	public String getEmail() {
		return oAuth2Response.getEmail();
	}

}
