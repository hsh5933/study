package com.springboot.api.controller;

import org.springframework.web.bind.annotation.*;

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
}
