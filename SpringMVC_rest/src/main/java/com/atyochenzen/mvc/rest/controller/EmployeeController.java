package com.atyochenzen.mvc.rest.controller;

import com.atyochenzen.mvc.rest.bean.Employee;
import com.atyochenzen.mvc.rest.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;//成為在IOC的範圍內

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        Collection<Employee> employeeList = employeeDao.getAll();
        model.addAttribute("employeeList", employeeList);
        return "employee_list";
    }
}
