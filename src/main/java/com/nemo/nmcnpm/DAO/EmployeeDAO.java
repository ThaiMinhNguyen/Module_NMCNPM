/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nemo.nmcnpm.DAO;

import com.nemo.nmcnpm.Entity.Employee;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface EmployeeDAO {
    
    public String addEmployee(Employee employee, EntityManager em);
    
    public void deleteEmployee(Employee employee, EntityManager em);
    
    public void updateEmployee(Employee employee, EntityManager em);
    
    public List<Employee> selectEmployee(String name, EntityManager em);
    
}
