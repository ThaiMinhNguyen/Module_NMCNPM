/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nemo.nmcnpm.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


/**
 *
 * @author Nemo
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "employee")
public class Employee {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;  
   
    @Column(nullable = false, length = 45, name = "fullname")
    private String fullName;
    
    @Column(length = 45, nullable = false, name = "username", unique = true)
    private String userName;

    @Column(length = 15, nullable = false)
    private String password;
    
    @Column
    private String position;
    
    @Column
    private String address;

    public Employee() {
    }
    
    public Employee(String id, String fullName, String userName, String password, String position, String address) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.position = position;
        this.address = address;
    }


    public Employee(String fullName, String userName, String password, String position, String address) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.position = position;
        this.address = address;
    }

    public Object[] toObject(){
        return new Object[]{id, fullName, userName, password, position, address};
    }
}
