package com.example.backend.clients.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    // Additional fields like company background, personas, etc.
    @Column(name = "background")
    private String background;

    @Column(name = "customer_personas")
    private String customerPersonas;

    @Column(name = "selling_points")
    private String sellingPoints;

    @JsonManagedReference // Use this to manage the relationship
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<ClientDocument> documents;

    // Getters and Setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getCustomerPersonas() {
        return customerPersonas;
    }

    public void setCustomerPersonas(String customerPersonas) {
        this.customerPersonas = customerPersonas;
    }

    public String getSellingPoints() {
        return sellingPoints;
    }

    public void setSellingPoints(String sellingPoints) {
        this.sellingPoints = sellingPoints;
    }

    public Set<ClientDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<ClientDocument> documents) {
        this.documents = documents;
    }
}

