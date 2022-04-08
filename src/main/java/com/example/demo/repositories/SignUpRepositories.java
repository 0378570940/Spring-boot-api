package com.example.demo.repositories;

import com.example.demo.entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepositories extends JpaRepository<UserEntity, Long> {
//    Boolean existsByUsername(String username);
//    Boolean existsByEmail(String email);
}
