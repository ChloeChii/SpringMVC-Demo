package com.atyochenzen.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/hello")
public class RequestMappingController {
    @RequestMapping(
            value = {"/testRequestMapping", "/test"},// 必須要有value
            method = {RequestMethod.GET, RequestMethod.POST}
    )

    public String success() {
        return "success";
    }

    @GetMapping("/testGetMapping")
    public String testGetMapping() {
        return "success";
    }

    @PostMapping("/testPostMapping")
    public String testPostMapping() {
        return "success";
    }

    @RequestMapping(value = "/testPut", method = RequestMethod.PUT)
    public String testPut() {
        return "success";
    }

    @RequestMapping(
            value = "/testParamsAndHeader",
            params = {"username", "password!=123456"},
            headers = {"Host=localhost:8080"}
    )

    public String testParamsAndHeader() {
        return "success";
    }

    //    @RequestMapping("/a?a/testAnt")//從瀏覽器發送的請求這個問號可以表示任意一個char
//    @RequestMapping("/a*a/testAnt")//從瀏覽器發送的請求這個問號可以表示任意一個char
    @RequestMapping("/**/testAnt")//從瀏覽器發送的請求這個問號可以表示任意一個char
    public String testAnt() {
        return "success";
    }


    @RequestMapping("/testPath/{id1}/{username}")//使用{}表示佔位符號
    public String testPath(@PathVariable("id1")Integer id, @PathVariable("username") String username ){//把testpath後面的id1透過PathVariable傳入，並且copy到input id
        System.out.println("id:" + id);
        return "success";
    }

}