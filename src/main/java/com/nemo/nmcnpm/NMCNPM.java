/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nemo.nmcnpm;

import com.nemo.nmcnpm.DAO.impl.EmployeeDAOImpl;
import com.nemo.nmcnpm.Entity.Employee;
import com.nemo.nmcnpm.Frame.EditEmployeePanel;
import com.nemo.nmcnpm.Frame.MainFrame;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class NMCNPM {

    public static void main(String[] args){
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("employee");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        Employee employee = new Employee("Nguyễn Thái Minh", "minh2", "22012003", "Seller");
//        EmployeeDAOImpl empl = new EmployeeDAOImpl();
//        empl.addEmployee(employee, entityManager);
//        empl.deleteEmployee(employee,entityManager);
        
        MainFrame mainFrame = new MainFrame(entityManager);
        mainFrame.setVisible(true);
        
//        EditEmployeePanel editEmployeePanel = new EditEmployeePanel(mainFrame, entityManager);
//        editEmployeePanel.setVisible(true);
          
//        entityManager.close();
//        entityManagerFactory.close();
    }
}
