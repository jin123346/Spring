package com.ch06.service;

import com.ch06.dto.User1DTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1ServiceTest {

    @Autowired
    private User1Service user1Service;


    @Test
    void insertUser1() {
        // 테스트 정의 : given - when - then 패턴

        // given : 테스트를 준비, 샘플 데이터 생성
        User1DTO sample = User1DTO.builder()
                .uid("a203")
                .name("김유신")
                .birth("1999-01-02")
                .hp("010-2222-1010")
                .age(22)
                .build();

        // when : 테스트를 진행
        user1Service.insertUser1(sample);

        // then : 테스트 검증, Assert 단정문을 이용해 결과 출력
        User1DTO expected = user1Service.selectUser1(sample.getUid());
        Assertions.assertEquals(expected.toString(), sample.toString());
    }

    @Test
    void selectUser1() {
        // given
        String uid = "a202";

        // when
        User1DTO expected = user1Service.selectUser1(uid);

        // then
        Assertions.assertEquals(expected.getUid(), uid);
    }

    @Test
    void selectUser1s() {
        List<User1DTO> expected = user1Service.selectUser1s();

        //Assertions.assertFalse(expected.isEmpty());  -> 성공
        Assertions.assertNotNull(expected);
        //Assertions.assertTrue(expected.isEmpty()); -> test 실패
    }

    @Test
    void updateUser1() {

        // given : 테스트를 준비, 샘플 데이터 생성
        User1DTO sample = User1DTO.builder()
                .uid("a202")
                .name("김유진")
                .birth("1999-12-22")
                .hp("010-2222-1220")
                .age(88)
                .build();

        // when : 테스트를 진행
        user1Service.updateUser1(sample);

        // then : 테스트 검증, Assert 단정문을 이용해 결과 출력
        User1DTO expected = user1Service.selectUser1(sample.getUid());
        Assertions.assertEquals(expected.toString(), sample.toString());
    }

    @Test
    void deleteUser1() {
        String uid = "a202";

        user1Service.deleteUser1(uid);

        User1DTO expected = user1Service.selectUser1(uid);
        Assertions.assertNull(expected);
    }
}