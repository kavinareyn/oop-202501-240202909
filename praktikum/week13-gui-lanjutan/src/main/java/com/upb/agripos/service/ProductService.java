package com.upb.agripos.service;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.model.Product;
import java.util.List;

public class ProductService {

    private final ProductDAO dao;

    public ProductService(ProductDAO dao) {
        this.dao = dao;
    }

    public List<Product> findAll() {
        return dao.findAll();
    }

    public void insert(Product p) {
        dao.insert(p);
    }

    public void delete(String code) {
        dao.delete(code);
    }
}
