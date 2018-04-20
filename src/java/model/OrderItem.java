/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import employee.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

/**
 *
 * @author Chronical
 */
public class OrderItem {
        
    private ServletContext context;

    private double price;
    private int quentity;
    private int order_id;
    private int acc_id;
    private int item_num;
    private double amount;

    public OrderItem(ServletContext context) {
        this.context = context;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the quentity
     */
    public int getQuentity() {
        return quentity;
    }

    /**
     * @param quentity the quentity to set
     */
    public void setQuentity(int quentity) {
        this.quentity = quentity;
    }

    /**
     * @return the order_id
     */
    public int getOrder_id() {
        return order_id;
    }

    /**
     * @param order_id the order_id to set
     */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    /**
     * @return the acc_id
     */
    public int getAcc_id() {
        return acc_id;
    }

    /**
     * @param acc_id the acc_id to set
     */
    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    /**
     * @return the item_num
     */
    public int getItem_num() {
        return item_num;
    }

    /**
     * @param item_num the item_num to set
     */
    public void setItem_num(int item_num) {
        this.item_num = item_num;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return quentity * price;
    }

    public Accessory getAccessory() throws SQLException {
              DataSource ds = (DataSource) context.getAttribute("dataSource");
            Connection conn = ds.getConnection();
            
        String sql = "SELECT * FROM accessories WHERE  acc_id = ?";
        PreparedStatement s_acc = conn.prepareStatement(sql);
        s_acc.setInt(1, acc_id);
        ResultSet rs = s_acc.executeQuery();
        rs.next();
        Accessory acc = new Accessory();
        acc.setAcc_id(acc_id);
        acc.setPrice(rs.getDouble("price"));
        acc.setDescription(rs.getString("description"));
        acc.setImage(rs.getString("image"));
        acc.setCate_cate_id(rs.getInt("cate_cate_id"));
        acc.setName(rs.getString("name"));
        
        if(conn !=null){
            try{
                conn.close();
            }catch(SQLException e){
                
            }
        }
        return acc;

    }
}
