/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nemo.nmcnpm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;



/**
 *
 * @author Nemo
 */
public class NMCNPM {

    public static void main(String[] args){
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("employee");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        
        
        entityManager.close();
        entityManagerFactory.close();
    }
}
