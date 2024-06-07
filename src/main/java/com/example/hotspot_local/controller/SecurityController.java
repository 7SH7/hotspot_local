package com.example.hotspot_local.controller;

import com.example.hotspot_local.config.SecurityConfig;
import com.example.hotspot_local.controller.response.OAuth.MemberResponse;
import com.example.hotspot_local.dto.CustomOAuth2User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.Collections;
import java.util.Map;

@RestController
//@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class SecurityController {

	@GetMapping("/logout")  // 이거 하면 user_entity에서 값을 삭제해버릴까? 그렇게 해서 로그인 여부 확인하면 될 듯..
	public ResponseEntity<?> logout(HttpServletRequest request) {
		var session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return ResponseEntity.ok().body("로그아웃되었습니다.");
	}



// 이미 config session에 저장됨
	@GetMapping("/login/test")
	public ResponseEntity<MemberResponse> user(@AuthenticationPrincipal CustomOAuth2User principal) {
		String email = principal.getEmail(); // 이건 없애도 됨.
//		String email2 = principal.
//		session.setAttribute("email", email);
		return ResponseEntity.ok().body(new MemberResponse(email));
	}
//  chrome에서 same = strong 인데, 그걸 none으로 바꿔줘야한다.
//	이걸 쿠키 / https(..)
}
