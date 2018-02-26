package domain;

import java.sql.Date;
import java.util.*;
import java.sql.*;

public class DataGenerator {
    private final Random random;

    public DataGenerator() {
        this.random = new Random();
    }

    public String address() {
        return "address-" + random.nextInt(50);
    }

    public Date date() {
        return new Date(new java.util.Date().getTime() - random.nextInt(10000000));
    }

    public String sellerName() {
        return "sellerName-" + random.nextInt(50);
    }

    public String shippingClass() {
        return "shippingClass-" + random.nextInt(10);
    }

    public String methodOfShipping() {
        return "methodOfShipping-" + random.nextInt(50);
    }

    public String customerName() {
        return "customerName-" + random.nextInt(50);
    }

}
