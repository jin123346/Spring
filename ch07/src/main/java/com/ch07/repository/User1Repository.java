package com.ch07.repository;

import com.ch07.entity.User1;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

// JpaRepository<T,ID> : 사용하는 엔티티 타입과 해당 엔티티의@id 컬럼 속성 타입 선언

@Repository
public interface User1Repository extends JpaRepository<User1, String> {  
    
    //쿼리작성 필요없이 기본적인 crud는 jpaRepostory가 해줌

    //사용자 정의 쿼리 메서드  => 개발자가 선언한 쿼리
    public User1 findUser1ByUid(String uid);  //select * from user1 where uid=?
    public List<User1> findUSer1ByName(String name);  // select * from user1 where name=?
    public List<User1> findUser1ByNameNot(String name);  // select * from user1 where name != ?


    public User1 findUser1ByUidAndName(String uid, String name);
    //select * from user1 where uid = ? and name=?;
    public List<User1> findUser1ByUidOrName(String uid, String name);
    //select * from user1 where uid=? or name=?;
    public List<User1> findUser1ByAgeGreaterThan(int age);
    //select * from user1 where age > ?
    public List<User1> findUser1ByAgeGreaterThanEqual(int age);
    //select * from user1 where age >= ?
    public List<User1> findUser1ByAgeLessThan(int age);
    //select * from user1 where age < ? ;
    public List<User1> findUser1ByAgeLessThanEqual(int age);
    //select * from user1 where age <=?;
    public List<User1> findUser1ByAgeBetween(int log,int high);
    //selelct * from user1 where age between ? and ?;


    public List<User1> findUser1ByNameLike(String name); //select * from user1 where name like name
    public List<User1> findUser1ByNameContains(String name); //select * from user1 where name like %name%
    public List<User1> findUser1ByNameStartsWith(String name); //select * from user1 where name like name% escape '\\'
    //select * from user1 where name like 'name%'
    public List<User1> findUser1ByNameEndsWith(String name);  //select * from user1 where name like %name escape '\\'

    public List<User1> findUser1ByOrderByName();  //select * from user1 order by name;
    public List<User1> findUser1ByOrderByAgeAsc(); //select * from user1 order by age asc;
    public List<User1> findUser1ByOrderByAgeDesc(); //select * from user1 order by age desc;
    public List<User1> findUser1ByAgeGreaterThanOrderByAgeDesc(int age); //select * from user1 where age >=? order by age desc;

    public int countUser1ByUid(String uid);
    public int countUser1ByName(String name);



    //JPQL : JPA Native SQL
    // user1은 entity 파일명과 일치시켜야하며, 해당 데이터베이스에 별칭을 지정해줘야함
    @Query("select u1 from User1 as u1 where u1.age < 30")
    public List<User1> selectUser1UnderAge30();

    //쿼리 파라미터 작성시 순서 지정해줘야함.?1 , ?2 ....
    @Query("select u1 from User1 as u1 where u1.name = ?1")
    public List<User1> selectUser1whereName(String name);


    //파라미터로 받기
    @Query("select u1 from User1 as u1 where u1.name = :name")
    public List<User1> selectUser1whereNameParam(@Param("name")  String name);

    @Query("select p,c from Parent as p " +
            "join Child as c " +
            "on p.pid = c.parent" +
            " where p.pid = :pid" )
    public List<Object[]> selectFromParentJoinChild(@Param("pid") String pid);

}
