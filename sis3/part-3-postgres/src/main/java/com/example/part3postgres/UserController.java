package com.example.part3postgres.api;

import com.example.part3postgres.domain.AppUser;
import com.example.part3postgres.domain.AppUserRepo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final AppUserRepo repo;

    public UserController(AppUserRepo repo) {
        this.repo = repo;
    }

    @PostMapping("/seed")
    @Transactional
    public String seed(@RequestParam(defaultValue = "500") int n) {
        for (int i = 0; i < n; i++) {
            var u = new AppUser(
                    "user" + i + "@mail.com",
                    "{\"plan\":\"free\",\"tags\":[\"kz\",\"ios\"]}"
            );
            repo.save(u);
            if (i % 25 == 0) {
                repo.flush();
            }
        }
        return "ok:" + n;
    }

    @GetMapping(params = "email")
    public AppUser byEmail(@RequestParam String email) {
        return repo.findByEmail(email).orElse(null);
    }

    @GetMapping("/search")
    public List<AppUser> byProfile(@RequestParam("json") String jsonFilter) {
        return repo.searchByProfile(jsonFilter);
    }
}