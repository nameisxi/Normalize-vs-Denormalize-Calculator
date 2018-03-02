package domain;

import java.sql.Date;
import java.util.*;
import java.sql.*;

public class DenormalizedShipping {
    private Integer id;
    private String customerName;
    private String sellerName;
    private Date date;
    private String shippingClass;
    private String address;
    private String methodOfShipping;

    public DenormalizedShipping(Integer id, String customerName, String sellerName, Date date, String shippingClass, String address, String methodOfShipping) {
        this.id = id;
        this.customerName = customerName;
        this.sellerName = sellerName;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
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
