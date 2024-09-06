package com.ch05.dao;

import com.ch05.dto.User1DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //mybatis scanning을 위해 @mapper선언 mapperscan 되기위해서는  mapper로 선언해주어야함, repository는 안됨
public interface User1Mapper {

    //method선언만 해놓음
    public void insertUser1(User1DTO  user1DTO);
    public User1DTO selectUser1(String uid);
    public List<User1DTO> selectUser1s();
    public void updateUser1(User1DTO user1DTO);
    public void deleteUser1(String uid);

}
