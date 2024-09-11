package com.ch09.service;

import com.ch09.dto.User1DTO;
import com.ch09.entity.User1;
import com.ch09.repository.User1Repository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Service
public class User1Service {

    // 'final'로 선언하여 생성자 주입
    private final User1Repository user1Repository;

    public User1DTO insertUser1(User1DTO user1DTO) {
        User1 entity = user1DTO.toEntity();
        User1 savedEntity = user1Repository.save(entity);

        return savedEntity.toDTO();
    }

    public User1DTO selectUser1(String uid) {
        Optional<User1> opt = user1Repository.findById(uid);
        return opt.map(User1::toDTO).orElse(null);
    }

    public List<User1DTO> selectUser1s() {
        List<User1> user1s = user1Repository.findAll();
        return user1s.stream().map(User1::toDTO).collect(Collectors.toList());
    }

    public User1DTO updateUser1(User1DTO user1DTO) {
        log.info(user1DTO);
        boolean result = user1Repository.existsById(user1DTO.getUid());
        if(result) {
            User1 entity = user1DTO.toEntity();
            User1 savedUser1= user1Repository.save(entity);
            return savedUser1.toDTO();
        }

        return null;
    }

    public void deleteUser1(String uid) {
        boolean opt = user1Repository.existsById(uid);
        if(!opt) {
            throw new EntityNotFoundException("해당하는 user가 없습니다.");
        }
        user1Repository.deleteById(uid);

    }
}

