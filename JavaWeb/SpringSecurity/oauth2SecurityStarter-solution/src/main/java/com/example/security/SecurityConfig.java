package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    }

    @Bean
    public WebClient rest(ClientRegistrationRepository clients, OAuth2AuthorizedClientRepository authz) {
        ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2 =
                new ServletOAuth2AuthorizedClientExchangeFilterFunction(clients, authz);
        return WebClient.builder().filter(oauth2).build();
    }

    @Bean
    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService(WebClient rest) {
        DefaultOAuth2UserService defaultOAuth2UserService = new DefaultOAuth2UserService();
        final OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService = new OAuth2UserService<OAuth2UserRequest, OAuth2User>() {
            @Override
            public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException {
                OAuth2User user = defaultOAuth2UserService.loadUser(request);
                String organizationUrl = user.getAttribute("organizations_url");
                OAuth2AuthorizedClient client = new OAuth2AuthorizedClient(request.getClientRegistration(), user.getName(), request.getAccessToken());
                List<Map<String, Object>> orgs = rest
                        .get().uri(organizationUrl)
                        .attributes(oauth2AuthorizedClient(client))
                        .retrieve()
                        .bodyToMono(List.class)
                        .block();

                if (orgs.stream().anyMatch(org -> "AWAcademyNO".equals(org.get("login")))) {
                    return user;
                }

                throw new OAuth2AuthenticationException(new OAuth2Error("invalid_token", "Not in AW Academy organization", ""));
            }
        };
        return oAuth2UserService;
    }


}
