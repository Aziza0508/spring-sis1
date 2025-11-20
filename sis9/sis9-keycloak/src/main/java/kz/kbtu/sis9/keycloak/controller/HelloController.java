package kz.kbtu.sis9.keycloak.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Public endpoint from Keycloak-protected app";
    }

    @GetMapping("/user")
    public String userEndpoint(@AuthenticationPrincipal Jwt jwt) {
        return "USER endpoint. Hello, " + jwt.getSubject();
    }

    @GetMapping("/admin")
    public String adminEndpoint(@AuthenticationPrincipal Jwt jwt) {
        return "ADMIN endpoint. Hello, " + jwt.getSubject();
    }
}
