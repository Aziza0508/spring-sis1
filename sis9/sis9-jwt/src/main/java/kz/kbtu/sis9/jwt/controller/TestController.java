package kz.kbtu.sis9.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Public endpoint - no auth required";
    }

    @GetMapping("/user")
    public String userEndpoint() {
        return "USER endpoint - requires ROLE_USER";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "ADMIN endpoint - requires ROLE_ADMIN";
    }
}
