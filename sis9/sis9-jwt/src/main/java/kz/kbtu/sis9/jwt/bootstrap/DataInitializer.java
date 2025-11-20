package kz.kbtu.sis9.jwt.bootstrap;

import kz.kbtu.sis9.jwt.model.User;
import kz.kbtu.sis9.jwt.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository users;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository users,
                           PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (users.findByUsername("user").isEmpty()) {
            User user = new User(
                    "user",
                    passwordEncoder.encode("password"),
                    "USER"
            );
            users.save(user);
        }

        if (users.findByUsername("admin").isEmpty()) {
            User admin = new User(
                    "admin",
                    passwordEncoder.encode("admin"),
                    "USER,ADMIN"
            );
            users.save(admin);
        }
    }
}
