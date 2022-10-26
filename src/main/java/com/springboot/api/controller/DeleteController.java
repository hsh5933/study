package com.springboot.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
    //@PathVariable과 @RequestParam을 활용한 Delete메서드구현
    //localhost:8080/api/v1/delete-api/{String값}

    @DeleteMapping(value = "/{variable}")
    public String DeleteVariable(@PathVariable String variable){
        return variable;
        //DeleteMapping어노테이션에 정의한 value이름과 메서드
        //매개변수 이름을 동일하게 설정해야 삭제값이 주입됨.
    }

    //localhost:8080/api/v1/delete-api/request1?email=value
    @DeleteMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String email){
        return "email : "+email;
    }
}
