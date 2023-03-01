package com.atyochenzen.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {
    //使用Servlet API向request域對象共享數據
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("testRequestScope", "hello,servletAPI");//這裡的testRequestScope是因為要接收前端的值，所以使用御index.html相同的標籤
        return "success";//這是一個視圖名稱,
    }
    
    @RequestMapping ("/testModelAndView")
    public ModelAndView testModelAndView(){//return value必須是ModelAndView
        ModelAndView mav = new ModelAndView();

        //處理模型數據 向請求域request共享數據
        mav.addObject("testRequestScope", "Hello,ModelAndView");
        //設置視圖名稱
        mav.setViewName("success");//這裡設定視圖名稱
        return mav;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestScope", "hello, Model");
        System.out.println(model.getClass().getName());//一般把物件印出來會得到內存地址.
        //使用.getClass().getName()的目的是看到全class名
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        map.put("testRequestScope", "Hello, Map");
        System.out.println(map.getClass().getName());//一般把物件印出來會得到內存地址
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope", "Hello, ModelMap");
        System.out.println(modelMap.getClass().getName());//一般把物件印出來會得到內存地址
        return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","Hello, Session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope", "Heoo, application");
        return "success";
    }
}
