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
        em.remove(employee);
        em.getTransaction().commit();
    }

    @Override
    public String updateEmployee(Employee employee, EntityManager em) {
        Employee e = em.find(Employee.class, employee.getId());
        em.getTransaction().begin();
        try {
            em.merge(employee);
            em.getTransaction().commit();
            return "Cập nhật thành công";
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return "Username đã tồn tại";
        }
    }

    @Override
    public List<Employee> selectEmployee(String name, EntityManager em) {
        return em.createQuery("SELECT e FROM Employee e WHERE e.fullName LIKE :name", Employee.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();

    }

}
