package com.springboot.api.dto;

public class MemberDto {
    /* DTO는 다른레어어간의 데이터 교환에 활용됨.
        각 클래스 및 인터페이스를 호출하면서 전달하는 매개변수로 사용되는 데이터객체
        데이터를 교환하는 용도로만 사용하는 객체이기때문에
        별도의 로직이 포함되어있지 않음.
    * */
    private String name;
    private String email;
    private String organization;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
