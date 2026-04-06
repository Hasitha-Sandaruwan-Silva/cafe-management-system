package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private int transactionId;
    private Timestamp transactionDate;
    private double totalAmount;
    private List<TransactionDetail> details;
    
    public Transaction() {
        this.details = new ArrayList<>();
    }
    
    public Transaction(int transactionId, Timestamp transactionDate, double totalAmount) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.totalAmount = totalAmount;
        this.details = new ArrayList<>();
    }
    
    
    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int transactionId) { this.transactionId = transactionId; }
    
    public Timestamp getTransactionDate() { return transactionDate; }
    public void setTransactionDate(Timestamp transactionDate) { this.transactionDate = transactionDate; }
    
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    
    public List<TransactionDetail> getDetails() { return details; }
    public void setDetails(List<TransactionDetail> details) { this.details = details; }
}