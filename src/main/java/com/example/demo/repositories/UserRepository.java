package com.example.demo.repositories;

import com.example.demo.entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findAllById(long id);

    UserEntity findUserById(long id);
}
