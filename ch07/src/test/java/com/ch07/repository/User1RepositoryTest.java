package com.ch07.repository;

import com.ch07.entity.Child;
import com.ch07.entity.Parent;
import com.ch07.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;

    @Test
    void findUser1ByUid() {
      User1 entity= user1Repository.findUser1ByUid("a101");
      assertNotNull(entity);
      System.out.println(entity);
    }

    @Test
    void findUSer1ByName() {
        List<User1> user1s  = user1Repository.findUSer1ByName("김길동");
        System.out.println(user1s);
    }

    @Test
    void findUser1ByNameNot() {
        List<User1> user1s = user1Repository.findUser1ByNameNot("김길동");
        System.out.println(user1s);
    }


    @Test
    void findUser1ByUidAndName() {
        User1 entity = user1Repository.findUser1ByUidAndName("a101","김길동");
        System.out.println(entity);

    }

    @Test
    void findUser1ByUidOrName() {
        List<User1> users = user1Repository.findUser1ByUidOrName("a101","김길동");
        System.out.println(users);

    }

    @Test
    void findUser1ByAgeGreaterThan() {
        List<User1> users = user1Repository.findUser1ByAgeGreaterThan(18);

        System.out.println(users);
    }

    @Test
    void findUser1ByAgeGreaterThanEqual() {
        List<User1> users = user1Repository.findUser1ByAgeGreaterThanEqual(23);
        System.out.println(users);
    }

    @Test
    void findUser1ByAgeLessThan() {
        List<User1> users = user1Repository.findUser1ByAgeLessThan(18);
        System.out.println(users);
    }

    @Test
    void findUser1ByAgeLessThanEqual() {
        List<User1> users = user1Repository.findUser1ByAgeLessThanEqual(23);
        System.out.println(users);
    }

    @Test
    void findUser1ByAgeBetween() {
        List<User1> users = user1Repository.findUser1ByAgeBetween(18,24);
        System.out.println(users);
    }



    @Test
    void findUser1ByNameLike(){
        List<User1> users = user1Repository.findUser1ByNameLike("김길동");
        System.out.println(users);
    } //select * from user1 where name like 'name' escape '\\'
    @Test
    void findUser1ByNameContains(){
        List<User1> users = user1Repository.findUser1ByNameContains("길동");
        System.out.println(users);
    } //select * from user1 where name like '%name% escape '\\'
    @Test
    void findUser1ByNameStartsWith(){
        List<User1> users = user1Repository.findUser1ByNameStartsWith("김");
        System.out.println(users);
    } //select * from user1 where name like 'name% escape '\\'

    @Test
    void findUser1ByNameEndsWith(){
        List<User1> users = user1Repository.findUser1ByNameEndsWith("동");
        System.out.println(users);
    }


    @Test
    void findUser1ByAgeGreaterThanOrderByAgeDesc(){
        List<User1> users = user1Repository.findUser1ByAgeGreaterThanOrderByAgeDesc(18);
        System.out.println(users);
    }


    @Test
    void selectUser1UnderAge30(){

    }
    @Test
    void selectUser1whereName(){

    }

    @Test
    void selectUser1whereNameParam(){

    }
    @Test
    void selectFromParentJoinChild(){
        List<Object[]> list= user1Repository.selectFromParentJoinChild("p101");
        System.out.println(list);

        for(Object[] obj : list){
            System.out.println(Arrays.toString(obj));
            Parent parent = (Parent) obj[0];
            Child child = (Child) obj[1];

            System.out.println(parent.toString());
            System.out.println(child.toString());
        }
    }



}