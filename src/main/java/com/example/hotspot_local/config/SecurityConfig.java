package com.example.hotspot_local.config;


import com.example.hotspot_local.service.CustomOAuth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private final CustomOAuth2UserService customOAuth2UserService;

  public SecurityConfig(CustomOAuth2UserService customOAuth2UserService) {
    this.customOAuth2UserService = customOAuth2UserService;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.csrf((csrf) -> csrf.disable());    // 여기..

    http.formLogin((login) -> login.disable());

    http.httpBasic((basic) -> basic.disable());

	http.headers().frameOptions().sameOrigin();

    //		oauth2Login() 메서드를 사용하여 OAuth 2.0 로그인을 활성화하고, (구현해야하는 filter같은 것을 기본적으로 지원해주는 것!)
    //		loginPage() 메서드를 사용하여 사용자가 로그인하려고 할 때 리디렉션할 URL을 지정합니다.

    //		oauth2Client() 메서드를 사용하여 OAuth 2.0 클라이언트 지원을 활성화합니다. (oauth2Login에서 기본적으로 제공해주는 filter에 속한
    // 것들을 일일히 다 customize해줘야한다. -> 복잡! )
    //		이 메서드는 OAuth 2.0 로그인을 사용하여 사용자가 로그인하려고 할 때 리디렉션할 URL을 지정합니다.

    http.oauth2Login(
        (oauth2) ->
            oauth2
                .userInfoEndpoint(
                    (userInfoEndpointConfig) ->
                        userInfoEndpointConfig.userService(customOAuth2UserService))
                .successHandler(
                    (request, response, authentication) -> {
                      response.sendRedirect("http://localhost:3000");
                    }));

//  session 관련된 것들은 다 여기서 처리해야함.

    http.authorizeHttpRequests(
        (auth) ->
            auth.requestMatchers("/get/**", "/login", "/stores/**", "/h2-console/**")
                .permitAll()
                // 유저 세션이 있으면 열어주고 없으면 막아주고 -> filter 하나를 만들어서 처리하면 좋아.
                // secuitycontextholder에 세션이 있으면 값을 넣어주는 방식을..
//                setAttribute로 해도 되고.
                .anyRequest()
                .authenticated());

    return http.build();
  }
}

