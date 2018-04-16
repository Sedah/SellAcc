/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chronical
 */
public class Cart {

    private List<OrderItem> accs;
    Connection conn;

    public void addItem(int acc_id, int quentity) {
        try {
            OrderItem item = null;
            for (int i = 0; i < accs.size(); i++) {
                OrderItem check = accs.get(i);
                int id = check.getAcc_id();
                if (acc_id == id) {
                   item = check;
                }

            }
            if (item == null) {
                String sql = "SELECT * FROM accessories WHERE  acc_id = ?";
                PreparedStatement s_acc = conn.prepareStatement(sql);
                s_acc.setInt(1, acc_id);
                ResultSet rs = s_acc.executeQuery();
                while (rs.next()) {
                    OrderItem acc = new OrderItem(conn);
                    acc.setAcc_id(acc_id);
                    acc.setQuentity(quentity);
                    acc.setPrice(rs.getDouble("price"));
                    accs.add(acc);
                }
            }
            else {
                quentity = item.getQuentity() + quentity;
                item.setQuentity(quentity);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<OrderItem> getAccs() {
        return accs;
    }

    public Cart(Connection conn) {
        this.conn = conn;
        accs = new LinkedList<OrderItem>();
    }


    public double getTotal() {
        double total = 0;
        for (int i = 0; i < accs.size(); i++) {
            OrderItem item = accs.get(i);
            double amount = item.getAmount();
            total += amount;
        }
        return total;
    }
    public double getPoint() {
        int point = 0;
        double totala = 0;
        totala = this.getTotal();
        point = (int) (totala/10);
        return point;
    }

}
