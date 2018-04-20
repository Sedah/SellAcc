/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Chronical
 */
public class Category {

    /**
     * @return the cate_id
     */
    public int getCate_id() {
        return cate_id;
    }

    /**
     * @param cate_id the cate_id to set
     */
    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
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
    private int cate_id;
    private String name;
}
