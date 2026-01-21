package com.upb.agripos.dao;

import com.upb.agripos.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private final List<Product> products = new ArrayList<>();

    public void insert(Product product) {
        products.add(product);
        // versi JDBC: INSERT ke PostgreSQL
    }

    public List<Product> findAll() {
        return products;
    }
}
