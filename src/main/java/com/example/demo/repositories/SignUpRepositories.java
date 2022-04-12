package com.example.demo.repositories;

import com.example.demo.entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignUpRepositories extends JpaRepository<UserEntity, Long> {
    UserEntity findFirstByName(String name);

    List<UserEntity> findAllById(String id);

    UserEntity findByName(String name);
}
