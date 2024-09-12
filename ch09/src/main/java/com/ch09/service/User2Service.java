package com.ch09.service;

import com.ch09.dto.User2DTO;
import com.ch09.entity.User2;
import com.ch09.repository.User2Repository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class User2Service {

    private final User2Repository user2Repository;

    public User2DTO InsertUser2(User2DTO user2dto) {
        User2 user2 = user2dto.toEntity();

        User2 savedUser2 = user2Repository.save(user2);

        return savedUser2.toDTO();


    }


    public User2DTO selectUser2(String uid){
        Optional<User2> opt=user2Repository.findById(uid);

        if(opt.isPresent()){
            User2 user2 = opt.get();
            return user2.toDTO();
        }

        return null;

    }
    public List<User2DTO> selectUser2s(){
        List<User2> user2s =  user2Repository.findAll();
        return user2s.stream().map(User2::toDTO).toList();
    }

    public User2DTO updateUser2(User2DTO user2dto) {
        boolean exist = user2Repository.existsById(user2dto.getUid());
        if(exist){
            User2 savedUser2 = user2Repository.save(user2dto.toEntity());
            return savedUser2.toDTO();
        }
        return null;
    }
    public void deleteUser2(String uid) {
        boolean exist = user2Repository.existsById(uid);

        if(!exist) {
            throw new EntityNotFoundException("해당하는 user가 없습니다.");
        }
            user2Repository.deleteById(uid);



    }


}
