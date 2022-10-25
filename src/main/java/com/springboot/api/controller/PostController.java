package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api") //공통url을 설정
public class PostController {

    //@RequestMapping구현하기
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "Hello Post API";
    }

    //http://localhost:8080/api/v1/post-api/member
    @PostMapping(value = "/member") //method요소를 정의하지않아도됨
    public String postMember(@RequestBody Map<String,Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map->{
            sb.append(map.getKey()+" "+map.getValue()+ "\n");
        });
        return sb.toString();
    }

    //DTO객체를 활용한 POST API구현
    //http://localhost:8080/api/v1/post-api/member2
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }

}
