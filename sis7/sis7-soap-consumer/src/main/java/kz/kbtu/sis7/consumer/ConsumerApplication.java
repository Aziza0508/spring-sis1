package kz.kbtu.sis7.consumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(StudentClient client) {
        return args -> {
            int id = 1;
            if (args.length > 0) {
                try {
                    id = Integer.parseInt(args[0]);
                } catch (NumberFormatException ignored) {
                }
            }
            var response = client.getStudent(id);
            if (response.getStudent() != null) {
                System.out.println("Student #" + response.getStudent().getId()
                        + " -> " + response.getStudent().getName()
                        + ", age=" + response.getStudent().getAge()
                        + ", gpa=" + response.getStudent().getGpa());
            } else {
                System.out.println("No student found with id=" + id);
            }
        };
    }
}
