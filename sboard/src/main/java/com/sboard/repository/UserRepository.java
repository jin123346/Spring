package com.sboard.repository;

import com.sboard.entity.User;
import org.hibernate.annotations.processing.Find;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

   public Optional<User> findByNick(String nick);

   public Optional<User> findByEmail(String email);

   public Optional<User> findByUidAndPass(String uid, String pass);

}
