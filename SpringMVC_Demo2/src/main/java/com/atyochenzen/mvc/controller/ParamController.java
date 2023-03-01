package com.atyochenzen.mvc.controller;

import com.atyochenzen.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ParamController {
    @RequestMapping("/testServletAPI")
    //形參位置的request表示當前請求
    public String testServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ", password: " + password);
        return "success";
    }

    @RequestMapping("testParam")
    public String testParam( @RequestParam(value = "user_name", required = false, defaultValue="hehe") String username,
                             String password,
                             String[] hobby,
                             @RequestHeader(value="sayHaha", required=true, defaultValue="haha") String host,
                             @CookieValue("JSESSIONID") String JSESSIONID
                             )
    {
        System.out.println("username:" + username + ", password: " + password +", hobby:" + Arrays.toString(hobby));
        System.out.println("host:" + host);
        System.out.println("JSESSIONID:" + JSESSIONID);
        return "success";
    }

    @RequestMapping("/testBean")
    //public String testBean(String username, String password...){//隨著以後傳遞參數越多，不太可能把整串參數打出來
    public String testBean(User user){
        System.out.println(user);

        return "success";
    }

}
