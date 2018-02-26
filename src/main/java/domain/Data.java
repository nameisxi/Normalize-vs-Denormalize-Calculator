package domain;

import java.sql.Date;

public class Data {
    String address;
    String sellerName;
    String shippingClass;
    String customerName;
    String methodOfShipping;
    Date date;

    public Data(String address, String sellerName, String shippingClass, String customerName, String methodOfShipping, Date date) {
        this.address = address;
        this.sellerName = sellerName;
        this.shippingClass = shippingClass;
        this.customerName = customerName;
        this.methodOfShipping = methodOfShipping;
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setsellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getShippingClass() {
        return shippingClass;
    }

    public void setShippingClass(String shippingClass) {
        this.shippingClass = shippingClass;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMethodOfShipping() {
        return methodOfShipping;
    }

    public void setMethodOfShipping(String methodOfShipping) {
        this.methodOfShipping = methodOfShipping;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
