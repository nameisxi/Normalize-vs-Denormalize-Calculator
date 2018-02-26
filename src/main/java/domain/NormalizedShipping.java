package domain;

import java.sql.Date;

public class NormalizedShipping {
    private Integer id;
    private Customer customer;
    private Seller seller;
    private Date date;
    private String shippingClass;
    private String address;
    private String methodOfShipping;

    public NormalizedShipping(Integer id, Customer customer, Seller seller, Date date, String shippingClass, String address, String methodOfShipping) {
        this.id = id;
        this.customer = customer;
        this.seller = seller;
        this.date = date;
        this.shippingClass = shippingClass;
        this.address = address;
        this.methodOfShipping = methodOfShipping;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getShippingClass() {
        return shippingClass;
    }

    public void setShippingClass(String shippingClass) {
        this.shippingClass = shippingClass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMethodOfShipping() {
        return methodOfShipping;
    }

    public void setMethodOfShipping(String methodOfShipping) {
        this.methodOfShipping = methodOfShipping;
    }
}
