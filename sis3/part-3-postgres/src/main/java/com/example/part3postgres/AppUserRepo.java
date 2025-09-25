package com.example.part3postgres.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByEmail(String email);

    @Query(value = """
        select * from app_user
        where profile @> cast(:jsonFilter as jsonb)
        """, nativeQuery = true)
    List<AppUser> searchByProfile(@Param("jsonFilter") String jsonFilter);
}