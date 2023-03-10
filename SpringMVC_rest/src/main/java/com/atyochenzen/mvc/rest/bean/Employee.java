package com.atyochenzen.mvc.rest.bean;

public class Employee {
    public Employee(){

    }

    public Employee(Integer id, String lastName, String email, Integer gender){
        super();
        this.id = id;
        this.lastname = lastName;
        this.email = email;
        this.gender = gender;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    private Integer id;
    private String lastname;
    private String email;
    private Integer gender;


}
