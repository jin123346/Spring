package com.ch07.service;

import com.ch07.dto.User1DTO;
import com.ch07.entity.User1;
import com.ch07.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class User1Service {

    private final User1Repository user1Repository;

    public void insertUser1(User1DTO user1DTO){
        // DTO를 Entity로 변환
        User1 entity = user1DTO.toEntity();

        // Entity 저장(데이터베이스 Insert)
        user1Repository.save(entity);    }
    public User1DTO selectUser1(String uid){
        /*
          optional
           - null 체크 검정을 손쉽고 안전하게 처리하기 위한 클래스
           - Spring JPA find ~ 메서드의 결과 타입
         */
        Optional<User1> opt= user1Repository.findById(uid);

        //entity 존재 여부 확인 후 Optional 타입으로 정의된 entity 가져오기
        if(opt.isPresent()){
            User1 user1 = opt.get();

            return user1.toDTO();
        }
        // user1이 존재하지않으면 null로 반환

        return null;
    }

    public List<User1DTO> selectUser1(){
        //Entity 전체 조회
        List<User1> user1s = user1Repository.findAll();
        // for(외부 반복자)를 이용한 entity 리트스를 dto로 변환
        /*  for(User1 user1 : user1s){
           user1DTOs.add(user1.toDTO());
       }*/

        //stream(내부반복자) 를 이용한 entity리스트를 dto로 변환
        //map ->  list를 일괄 실행
       List<User1DTO> users= user1s
                                .stream()
                                .map(entity -> entity.toDTO())
                                .collect(Collectors.toList());


        return users;
    }

    public void updateUser1(User1DTO user1DTO){
       boolean result=  user1Repository.existsById(user1DTO.getUid());

        if(result){
            //dto를entity로 변환
            User1 entity = user1DTO.toEntity();

            //entity를 수정(데이터베이스 update)
            user1Repository.save(entity);

        }
    }

    public void deleteUser1(String uid){
       //entity 삭제
        user1Repository.deleteById(uid);
    }
}
