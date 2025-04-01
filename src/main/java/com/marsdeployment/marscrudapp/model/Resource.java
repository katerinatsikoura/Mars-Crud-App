package com.marsdeployment.marscrudapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Resource {

    /**
    * Resource's id.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * Resource's name.
    */
    private String name;

    /**
    * Resource's quantity.
    */
    private int quantity;

    
    /**
    * Default constructor declaration.
    */
    public Resource() {}

    /**
    * Core constructor.
    * 
    * @param name        The name of the resource
    * @param quantity    Resource's quantity
    * 
    */
    public Resource(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    /**
    * Gets the id of the resource.
    * 
    * @return The resource id.
    */
    public Long getId() {
        return id;
    }

    /**
    * Sets the id of the resource.
    * 
    * @param id resource's id
    */
    public void setId(Long id) {
        this.id = id;
    }

    /**
    * Gets the resource's name.
    * 
    * @return resource's name
    */
    public String getName() {
        return name;
    }

    /**
    * Sets the name of the resource.
    * 
    * @param name
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * Gets the resource's quantity.
    * 
    * @return resource's quantity
    */
    public int getQuantity() {
        return quantity;
    }

    /**
    * Sets the quantity of the resource.
    * 
    * @param quantity
    */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
