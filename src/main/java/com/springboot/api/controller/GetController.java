package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api") //공통으로 들어가는 주소
public class GetController {

    // http://localhost:8080/api/v1/get-api/hello 주소와 같은의미
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "Hello World";
    }

    //http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName(){
        return "Flature";
    }

    //@PathVariable을 활용한 GET메서드구현
    //http://localhost:8080/api/v1/get-api/variable1/{String값}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    //PathVariable에 변수명을 매핑하는법
    //http://localhost:8080/api/v1/get-api/variable2/{String값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
        //주소에들어가는 variable과 String변수명이 일치하지않는상황에서 매핑
    }

    //http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    //RequestParam을 활용한 get메서드구현 uri기준으로 우측에 {키}={값} 형태
    @GetMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String name,
                                   @RequestParam String email,
                                   @RequestParam String organization){
        return name + " " + email + " " + organization;
    }

    //http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String,String> param){
        StringBuilder sb = new StringBuilder(); //변경가능한 문자열을 만들어줌
        //entrySet() 메서드는 key와 value의 값 모두 출력
        //
        //keySet() 메서드는 key의 값만 출력
        //
        //Iterator는 자바의 컬렉션 프레임워크에서 컬렉션에 저장되어 있는 요소들을 읽어오는 방법
        param.entrySet().forEach(map->{
            sb.append(map.getKey()+" "+map.getValue()+"\n");
        });
        return sb.toString();
    }


        /* URI와 URL의 차이
        URL은 우리가 흔히 말하는 웹주소를 의미
        URI는 특정 리소스를 식별할수있는 식별자를 의미
        * */

        //DTO객체를 이용한 GET메서드 구현
        //http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
        @GetMapping(value = "/request3")
                public String getRequestParam3(MemberDto memberDto){
            return memberDto.toString();
        }

}
