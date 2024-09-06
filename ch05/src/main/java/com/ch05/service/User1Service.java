package com.ch05.service;

import com.ch05.dao.User1Mapper;
import com.ch05.dto.User1DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User1Service {

    //final 하게되면 생성자가 반드시 나와야함
    private final User1Mapper user1Mapper;

    @Autowired //autowired 생략가능
    public User1Service(User1Mapper user1Mapper) {
        this.user1Mapper = user1Mapper;
    }

    public void insertUser1(User1DTO user1DTO){
        user1Mapper.insertUser1(user1DTO);
    }
    public User1DTO selectUser1(String uid){
        return user1Mapper.selectUser1(uid);
    }
    public List<User1DTO> selectUser1s(){
        return user1Mapper.selectUser1s();
    }
    public void updateUser1(User1DTO user1DTO){
        user1Mapper.updateUser1(user1DTO);
    }
    public void deleteUser1(String uid){
        user1Mapper.deleteUser1(uid);
    }


}
