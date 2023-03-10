package com.atyochenzen.mvc.rest.dao;

import com.atyochenzen.mvc.rest.bean.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "E-AA", "aa@111.com", 1));
        employees.put(1002, new Employee(1002, "E-BB", "bb@111.com", 1));
        employees.put(1003, new Employee(1003, "E-CC", "cc@111.com", 1));
        employees.put(1004, new Employee(1004, "E-DD", "dd@111.com", 0 ));
        employees.put(1005, new Employee(1005, "E-EE", "ee@111.com", 0));
    }
    private static Integer initId = 1006;

    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }
        employees.put(employee.getId(), employee);
    }
    public Collection<Employee> getAll(){
        return employees.values();
    }
    public Employee get(Integer id){
        return employees.get(id);
    }
    public void delete(Integer id){
        employees.remove(id);
    }
}
