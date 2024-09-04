package com.ch04.dao;

import com.ch04.config.JdbcConfig;
import com.ch04.dto.User1DTO;
import com.ch04.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class User1DAO {

    //spring에서는 직접 싱글톤 설정할 필요없다. ==> repository
   /* private static User1DAO instance = new User1DAO();
    public static User1DAO getInstance() {
        return instance;
    }*/

    //jdbc 템플릿 선언
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public User1DAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertUser1(User1DTO dto){

        String sql="insert into user1 values(?,?,?,?,?)";
        Object[] params = {
                dto.getUid(),
                dto.getName(),
                dto.getBirth(),
                dto.getHp(),
                dto.getAge()
        };
        //spring jdbc
        jdbcTemplate.update(sql, params);



    }
    public User1DTO  selectUser1(String uid){
        String sql="select * from user1 where uid=?";
        User1DTO user1dto = (User1DTO) jdbcTemplate.queryForObject(sql, new User1RowMapper(),uid);

        return user1dto;
    }
    public List<User1DTO> selectUser1s(){

        String sql="select * from user1";


        return jdbcTemplate.query(sql, new User1RowMapper());
    }
    public void updateUser1(User1DTO dto){

        String sql= "update user1 set name=?,birth=?,hp=?,age=? where uid=?";
        Object[] params = {
                dto.getName(),
                dto.getBirth(),
                dto.getHp(),
                dto.getAge(),
                dto.getUid()
        };
        jdbcTemplate.update(sql, params);

    }
    public void deleteUser1(String uid){
        String sql="delete from user1 where uid=?";
        jdbcTemplate.update(sql, uid);

    }


}
