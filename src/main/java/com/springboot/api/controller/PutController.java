package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api") //공통url을 설정
public class PutController {

    //http://localhost:8080/api/v1/put-api/member
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String,Object> putData){
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map->{
            sb.append(map.getKey()+" : "+map.getValue()+"\n");
        });
        return sb.toString();
    }

    //DTO객체를 활용한 PUT메서드 구현
    //http://localhost:8080/api/v1/put-api/member1
    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }
    //http://localhost:8080/api/v1/put-api/member1
    @PutMapping(value ="/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto){
        return memberDto;
    }

    //ResponseEntity를 활용한 PUT메서드 구현
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);
        //HttpStatus.ACCEPTED 는 응답코드를 202로 변경하는코드

    }
}
