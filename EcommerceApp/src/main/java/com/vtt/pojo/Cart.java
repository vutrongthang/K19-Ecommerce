package com.vtt.pojo;

import java.io.Serializable;

public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String name;
    private Long price;
    private int quantity;

    public Cart() {
    }

    public Cart(int id, String name, Long price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
