package com.example.demo.repositories;

import com.example.demo.entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepositories extends JpaRepository<UserEntity, Long> {
    UserEntity findFirstByName(String name);

    UserEntity findById(long tokenId);

    Boolean existsByName(String name);

    Boolean existsByEmail(String email);
}
