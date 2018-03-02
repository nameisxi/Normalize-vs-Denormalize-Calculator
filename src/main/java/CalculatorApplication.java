import dao.DenormalizedShippingDao;
import dao.NormalizedShippingDao;
import dao.SellerDao;
import dao.CustomerDao;
import db.DenormalizedDatabase;
import db.NormalizedDatabase;
import domain.*;

import java.io.File;
import java.util.*;

public class CalculatorApplication {

    public static void main(String[] args) throws Exception {
        DataGenerator generator = new DataGenerator();
        List<Data> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(new Data(generator.address(), generator.sellerName(), generator.shippingClass(), generator.customerName(), generator.methodOfShipping(), generator.date()));
        }

        // Denormalized database
        File dbFile1 = new File("db", "denormalized.db");

        DenormalizedDatabase denormalizedDB = new DenormalizedDatabase("jdbc:sqlite:" + dbFile1.getAbsolutePath());
        DenormalizedShippingDao dnEventDao = new DenormalizedShippingDao(denormalizedDB);

        long start1 = System.nanoTime();
        int id1 = 1;
        for (Data row : data) {
            DenormalizedShipping dn = new DenormalizedShipping(id1, row.getCustomerName(), row.getSellerName(), row.getDate(), row.getShippingClass(), row.getAddress(), row.getMethodOfShipping());
            dnEventDao.saveOrUpdate(dn);
            id1++;
        }

        long end1 = System.nanoTime();
        System.out.println("+--------------------------------------------------------------------------------------------------------+");
        System.out.println("|  It took " + ((double)(end1 - start1) / 1000000000.0) + " seconds, or " + (end1 - start1)  + " nanoseconds to add the data to the denormalized database.");
        System.out.println("+--------------------------------------------------------------------------------------------------------+");


        // Normalized database
        File dbFile2 = new File("db", "normalized.db");

        NormalizedDatabase normalizedDB = new NormalizedDatabase("jdbc:sqlite:" + dbFile2.getAbsolutePath());
        NormalizedShippingDao nEventDao = new NormalizedShippingDao(normalizedDB);
        CustomerDao customerDao = new CustomerDao(normalizedDB);
        SellerDao sellerDao = new SellerDao(normalizedDB);

        long start2 = System.nanoTime();
        int id2 = 1;
        for (Data row : data) {
            Customer customer = new Customer(id2, row.getCustomerName());
            customerDao.saveOrUpdate(customer);
            Seller seller = new Seller(id2, row.getSellerName());
            sellerDao.saveOrUpdate(seller);
            NormalizedShipping ne = new NormalizedShipping(id2, customer, seller, row.getDate(), row.getShippingClass(), row.getAddress(), row.getMethodOfShipping());
            nEventDao.saveOrUpdate(ne);
            id2++;
        }

        long end2 = System.nanoTime();
        System.out.println("|  It took " + ((double)(end2 - start2) / 1000000000.0) + " seconds, or " + (end2 - start2)  + " nanoseconds to add the data to the normalized database.");
        System.out.println("+--------------------------------------------------------------------------------------------------------+");
    }

}
