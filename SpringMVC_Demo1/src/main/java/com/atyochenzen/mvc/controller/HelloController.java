package com.atyochenzen.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Date: 2023/2/11
 * Author:
 * Description:
 */
@Controller
public class HelloController {
    //"/" -->/WEB-INF/templates/index.html

    //真正處理請求的方法
    @RequestMapping(value="/")//創建映射關係
    public String index(){
        //return 視圖名稱，決定我們最終要跳轉的頁面, 當返回視圖解析，就會被先前配置好的thymeleaf接收並處理請求
        //thymeleaf會搭配前綴後綴組成最後要direct的URL
        //因此這裡只需要把前綴後綴去掉，就是視圖名稱
        //前綴/WEB-INF/templates/
        //後綴.html
        return "index";
    }
    @RequestMapping(value="/target")
    public String toTarget(){
        return "target";
    }
}
