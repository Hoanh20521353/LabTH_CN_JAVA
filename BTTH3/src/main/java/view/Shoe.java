/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author hoanhnguyen
 */
public class Shoe {
    private String title;
    private String note;
    private String imagePath;
    private String brand;
    private String price;
    private Shoe newShoe;

    public Shoe(String title, String note, String imagePath, String brand, String price) {
        this.title = title;
        this.note = note;
        this.imagePath = imagePath;
        this.brand = brand;
        this.price = price;
    }

    // Getter methods
    public String getTitle() { return title; }
    public String getNote() { return note; }
    public String getImagePath() { return imagePath; }
    public String getBrand() { return brand; }
    public String getPrice() { return price; }
    //
    public void setShoe(Shoe newShoe) {
        this.newShoe=newShoe;
    }
}

