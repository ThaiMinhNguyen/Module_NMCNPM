/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nemo.nmcnpm.DAO.impl;

import com.nemo.nmcnpm.DAO.EmployeeDAO;
import com.nemo.nmcnpm.Entity.Employee;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author Admin
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public String addEmployee(Employee employee, EntityManager em) {
        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            return "Đã thêm nhân viên thành công!";
        } catch (Exception e) {
            em.getTransaction().rollback();
            return "ID nhân viên hoặc username đã tồn tại";
            // Re-throw the exception to handle it outside this method if needed
        }
    }

    @Override
    public void deleteEmployee(Employee employee, EntityManager em) {
        em.getTransaction().begin();
        Employee e = em.find(Employee.class, employee.getId());
        em.remove(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateEmployee(Employee employee, EntityManager em) {
        Employee e = em.find(Employee.class, employee.getId());
        em.getTransaction().begin();
        e.setFullName(employee.getFullName());
        e.setPassword(employee.getPassword());
        e.setUserName(employee.getUserName());
        e.setPosition(employee.getPosition());
        e.setAddress(employee.getAddress());
        //em.merge(employee);
        em.getTransaction().commit();
    }

    @Override
    public List<Employee> selectEmployee(String name, EntityManager em) {
        return em.createQuery("SELECT e FROM Employee e WHERE e.fullName LIKE :name", Employee.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
        
    }

}
