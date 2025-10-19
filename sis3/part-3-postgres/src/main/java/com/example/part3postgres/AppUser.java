package com.example.part3postgres.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_user_seq_gen")
    @SequenceGenerator(name = "app_user_seq_gen", sequenceName = "app_user_seq", allocationSize = 50)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(columnDefinition = "jsonb", nullable = false)
    private String profile = "{}";

    protected AppUser() {}

    public AppUser(String email, String profile) {
        this.email = email;
        this.profile = profile;
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getProfile() { return profile; }
    public void setProfile(String profile) { this.profile = profile; }
}