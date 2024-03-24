package com.example.management.repository.user;

import com.example.management.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);

}
