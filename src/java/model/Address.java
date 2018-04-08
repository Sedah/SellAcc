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
public class Address {
    private int add_id;
    private String province;
    private String district;
    private String house_num;
    private String street;
    private String area;
    private String postcode;
    private String status;
    private int member_cus_id;

    /**
     * @return the add_id
     */
    public int getAdd_id() {
        return add_id;
    }

    /**
     * @param add_id the add_id to set
     */
    public void setAdd_id(int add_id) {
        this.add_id = add_id;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return the house_num
     */
    public String getHouse_num() {
        return house_num;
    }

    /**
     * @param house_num the house_num to set
     */
    public void setHouse_num(String house_num) {
        this.house_num = house_num;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * @param postcode the postcode to set
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
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
     * @return the member_cus_id
     */
    public int getMember_cus_id() {
        return member_cus_id;
    }

    /**
     * @param member_cus_id the member_cus_id to set
     */
    public void setMember_cus_id(int member_cus_id) {
        this.member_cus_id = member_cus_id;
    }
}
