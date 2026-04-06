package controller;

import config.DatabaseConfig;
import model.Transaction;
import model.TransactionDetail;
import java.sql.*;
import javax.swing.JOptionPane;

public class TransactionController {
    
    public boolean saveTransaction(Transaction transaction) {
        Connection conn = null;
        PreparedStatement pstmtTrans = null;
        PreparedStatement pstmtDetail = null;
        PreparedStatement pstmtStock = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConfig.getConnection();
            conn.setAutoCommit(false); 
            
            
            String transQuery = "INSERT INTO transactions (total_amount) VALUES (?)";
            pstmtTrans = conn.prepareStatement(transQuery, Statement.RETURN_GENERATED_KEYS);
            pstmtTrans.setDouble(1, transaction.getTotalAmount());
            pstmtTrans.executeUpdate();
            
            
            rs = pstmtTrans.getGeneratedKeys();
            int transactionId = 0;
            if (rs.next()) {
                transactionId = rs.getInt(1);
            }
            
            
            String detailQuery = "INSERT INTO transaction_details (transaction_id, item_id, quantity, price, subtotal) VALUES (?, ?, ?, ?, ?)";
            pstmtDetail = conn.prepareStatement(detailQuery);
            
            String stockQuery = "UPDATE items SET stock_quantity = stock_quantity - ? WHERE item_id = ?";
            pstmtStock = conn.prepareStatement(stockQuery);
            
           
            for (TransactionDetail detail : transaction.getDetails()) {
                
                pstmtDetail.setInt(1, transactionId);
                pstmtDetail.setInt(2, detail.getItemId());
                pstmtDetail.setInt(3, detail.getQuantity());
                pstmtDetail.setDouble(4, detail.getPrice());
                pstmtDetail.setDouble(5, detail.getSubtotal());
                pstmtDetail.executeUpdate();
                
               
                pstmtStock.setInt(1, detail.getQuantity());
                pstmtStock.setInt(2, detail.getItemId());
                pstmtStock.executeUpdate();
            }
            
            conn.commit();
            return true;
            
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(null, "Error saving transaction: " + e.getMessage());
            return false;
        } finally {
           
            try {
                if (rs != null) rs.close();
                if (pstmtTrans != null) pstmtTrans.close();
                if (pstmtDetail != null) pstmtDetail.close();
                if (pstmtStock != null) pstmtStock.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}