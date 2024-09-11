package com.ch08.repository;

import com.ch08.dto.UserDTO;
import com.ch08.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User , String> {

    public Optional<User> findUserByUsernameAndPassword(String username, String password);

}
