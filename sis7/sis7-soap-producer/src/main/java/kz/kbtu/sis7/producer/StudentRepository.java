package kz.kbtu.sis7.producer;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import kz.kbtu.sis7.producer.soap.Student;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class StudentRepository {

    private final Map<Integer, Student> students = new HashMap<>();

    @PostConstruct
    public void init() {
        Student alice = new Student();
        alice.setId(1);
        alice.setName("Alice");
        alice.setAge(20);
        alice.setGpa(3.5);
        students.put(alice.getId(), alice);

        Student bob = new Student();
        bob.setId(2);
        bob.setName("Bob");
        bob.setAge(22);
        bob.setGpa(3.8);
        students.put(bob.getId(), bob);

        Student charlie = new Student();
        charlie.setId(3);
        charlie.setName("Charlie");
        charlie.setAge(21);
        charlie.setGpa(3.2);
        students.put(charlie.getId(), charlie);
    }

    public Student findById(int id) {
        Assert.isTrue(id > 0, "id must be positive");
        return students.get(id);
    }
}
