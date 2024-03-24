package com.example.management.repository.user;

import com.example.management.entity.user.Authority;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface AuthorityRepository extends JpaRepository<Authority,Long> {

    Authority findByName(String name);

    @Modifying
    @Query(value = "INSERT INTO authorities(name) VALUES (:roleName)", nativeQuery = true)
    @Transactional
    void saveAuth(@Param("roleName") String roleName);
}
