/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hasitha
 */
public class Item {
    private int itemId;
    private String itemName;
    private double price;
    private int stockQuantity;
    private String category;
    
    
    public Item() {}
    
    public Item(int itemId, String itemName, double price, int stockQuantity, String category) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }
    
    // Getters and Setters
    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }
    
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
