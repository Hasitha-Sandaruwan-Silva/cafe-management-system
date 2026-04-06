package model;

public class TransactionDetail {
    private int detailId;
    private int transactionId;
    private int itemId;
    private String itemName;
    private int quantity;
    private double price;
    private double subtotal;
    
    public TransactionDetail() {}
    
    public TransactionDetail(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = quantity * price;
    }
    
  
    public int getDetailId() { return detailId; }
    public void setDetailId(int detailId) { this.detailId = detailId; }
    
    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int transactionId) { this.transactionId = transactionId; }
    
    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }
    
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { 
        this.quantity = quantity;
        this.subtotal = quantity * price;
    }
    
    public double getPrice() { return price; }
    
    public void setPrice(double price) 
    { 
        this.price = price;
        this.subtotal = quantity * price;
    }
    
    public double getSubtotal() {
        return subtotal; 
    }
    
    
    public void setSubtotal(double subtotal)
    {
       this.subtotal = subtotal; 
    }
    
}