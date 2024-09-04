package com.ch04.dao;

import com.ch04.dto.User2DTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.rmi.server.UID;
import java.util.List;

@Repository
public class User2DAO {

    private JdbcTemplate jdbcTemplate;

    public User2DAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertUser2(User2DTO dto){

        String sql = "insert into user2 values(?,?,?,?)";
        Object[] params = new Object[]{
                dto.getUid(),
                dto.getName(),
                dto.getBirth(),
                dto.getAddr()
        };
        jdbcTemplate.update(sql, params);


    }
    public User2DTO selectUser2(String uid){
        String sql = "select * from user2 where uid=?";
        User2DTO dto = (User2DTO) jdbcTemplate.queryForObject(sql, new User2RowMapper(),uid);
        return dto;
    }
    public List<User2DTO> selectUsers2(){
        String sql = "select * from user2";
        return   jdbcTemplate.query(sql, new User2RowMapper());
    }
    public void updateUser2(User2DTO dto){
        String sql="update user2 set name=?,birth=?,addr=? where uid=?";
        Object[] params = new Object[]{
                dto.getName(),
                dto.getBirth(),
                dto.getAddr(),
                dto.getUid()
        };

        jdbcTemplate.update(sql, params);

    }
    public void deleteUser2(String uid){
        String sql  = "delete from user2 where uid=?";
        jdbcTemplate.update(sql, uid);

    }


}
