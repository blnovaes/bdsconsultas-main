/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devsuperior.uri2602.dto;

import com.devsuperior.uri2602.projections.CustomerMinProjection;

/**
 *
 * @author blnov
 */
public class CustomerMinDTO {

    private String name;

    public CustomerMinDTO() {

    }

    public CustomerMinDTO(String name) {
        this.name = name;
    }
    
        public CustomerMinDTO(CustomerMinProjection projection) {
        name =  projection.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomerMinDTO{" + "name=" + name + '}';
    }
    

}
