package com.example.shoe_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String brand;
    private String description;
    private String image;

    public Product(){}
    public Product( String name,double price,String brand,String description, String image){
        this.name=name;
        this.price=price;
        this.brand=brand;
        this.description=description;
        this.image=image;
    };
    @Override
    public String toString() {
        return "Product{" +
            " id = " + id +
            ", name = '" + name + '\'' +
            ", price = " + price +
            ", brand = '" + brand + '\'' +
            ", description = '" + description + '\'' +
            ", image = '" + image + '\'' +
            " }";
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
