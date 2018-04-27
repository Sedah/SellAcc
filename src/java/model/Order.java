/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Chronical
 */
public class Order {
    private int order_id;
    private Date buy_date;
    private String status;
    private int use_point;
    private int recieve_point;
    private double total_price;
    private String address;
    private int cus_cus_id;

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
     * @return the buy_date
     */
    public Date getBuy_date() {
        return buy_date;
    }

    /**
     * @param buy_date the buy_date to set
     */
    public void setBuy_date(Date buy_date) {
        this.buy_date = buy_date;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the use_point
     */
    public int getUse_point() {
        return use_point;
    }

    /**
     * @param use_point the use_point to set
     */
    public void setUse_point(int use_point) {
        this.use_point = use_point;
    }

    /**
     * @return the recieve_point
     */
    public int getRecieve_point() {
        return recieve_point;
    }

    /**
     * @param recieve_point the recieve_point to set
     */
    public void setRecieve_point(int recieve_point) {
        this.recieve_point = recieve_point;
    }

    /**
     * @return the total_price
     */
    public double getTotal_price() {
        return total_price;
    }

    /**
     * @param total_price the total_price to set
     */
    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the cus_cus_id
     */
    public int getCus_cus_id() {
        return cus_cus_id;
    }

    /**
     * @param cus_cus_id the cus_cus_id to set
     */
    public void setCus_cus_id(int cus_cus_id) {
        this.cus_cus_id = cus_cus_id;
    }
    
}
