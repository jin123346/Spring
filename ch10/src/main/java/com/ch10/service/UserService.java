package com.ch10.service;


import com.ch10.dto.UserDTO;
import com.ch10.entity.User;
import com.ch10.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void insertUser(UserDTO userdto) {
        userRepository.save(userdto.toEntity());
    }
    public UserDTO selectUser(String username){
        Optional<User> opt = userRepository.findById(username);
        if(opt.isPresent()){
             User user=opt.get();
            return user.toDTO();
        }
        return null;

    }

    public UserDTO loginUser(UserDTO userdto) {
         Optional<User> opt = userRepository.findUserByUsernameAndPassword(userdto.getUsername(), userdto.getPassword());
        if(opt.isPresent()){
            User user=opt.get();
            return user.toDTO();
        }

        return null;
    }
    public List<UserDTO> selectUsers(){
        return null;
    }


}
