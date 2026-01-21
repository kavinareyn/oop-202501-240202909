package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import java.util.List;

public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    public List<Product> load() {
        return service.findAll();
    }

    public void add(Product p) {
        service.insert(p);
    }

    public void delete(String code) {
        service.delete(code);
    }
}
