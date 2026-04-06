package controller;

import config.DatabaseConfig;
import model.Item;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ItemController {
    
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement pst = con.prepareStatement("SELECT * FROM items");
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                
                items.add(new Item(
                    rs.getInt("item_id"),
                    rs.getString("item_name"),
                    rs.getDouble("price"),
                    rs.getInt("stock_quantity"),
                    rs.getString("category")
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Load Error: " + e.getMessage());
        }
        return items;
    }
    
    public boolean addItem(Item item) {
        String sql = "INSERT INTO items (item_name, price, stock_quantity, category) VALUES (?, ?, ?, ?)";
        
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, item.getItemName());
            pst.setDouble(2, item.getPrice());
            pst.setInt(3, item.getStockQuantity());
            pst.setString(4, item.getCategory());
            
            return pst.executeUpdate() > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Add Error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean updateItem(Item item) {
        String sql = "UPDATE items SET item_name=?, price=?, stock_quantity=?, category=? WHERE item_id=?";
        
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, item.getItemName());
            pst.setDouble(2, item.getPrice());
            pst.setInt(3, item.getStockQuantity());
            pst.setString(4, item.getCategory());
            pst.setInt(5, item.getItemId());
            
            return pst.executeUpdate() > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Update Error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deleteItem(int itemId) {
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement pst = con.prepareStatement("DELETE FROM items WHERE item_id=?")) {
            
            pst.setInt(1, itemId);
            return pst.executeUpdate() > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Delete Error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean updateStock(int itemId, int quantity) {
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement pst = con.prepareStatement("UPDATE items SET stock_quantity = stock_quantity - ? WHERE item_id = ?")) {
            
            pst.setInt(1, quantity);
            pst.setInt(2, itemId);
            return pst.executeUpdate() > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Stock Update Error: " + e.getMessage());
            return false;
        }
    }
}