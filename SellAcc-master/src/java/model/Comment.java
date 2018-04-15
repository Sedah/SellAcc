/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;



/**
 *
 * @author Chronical
 */
public class Comment {
    private int comm_id;
    private String name;
    private String review;
    private Timestamp date;
    private int cus_cus_id;
    private int acc_acc_id;
    private Customer customer;
    /**
     * @return the comm_id
     */
    public int getComm_id() {
        return comm_id;
    }

    /**
     * @param comm_id the comm_id to set
     */
    public void setComm_id(int comm_id) {
        this.comm_id = comm_id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the review
     */
    public String getReview() {
        return review;
    }

    /**
     * @param review the review to set
     */
    public void setReview(String review) {
        this.review = review;
    }

    /**
     * @return the date
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Timestamp date) {
        this.date = date;
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

    /**
     * @return the acc_acc_id
     */
    public int getAcc_acc_id() {
        return acc_acc_id;
    }

    /**
     * @param acc_acc_id the acc_acc_id to set
     */
    public void setAcc_acc_id(int acc_acc_id) {
        this.acc_acc_id = acc_acc_id;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
