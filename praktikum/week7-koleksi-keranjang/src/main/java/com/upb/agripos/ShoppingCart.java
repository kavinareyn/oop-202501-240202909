package com.upb.agripos;

import java.util.ArrayList;

public class ShoppingCart {
    private final ArrayList<com.upb.agripos.Product> items = new ArrayList<>();

    public void addProduct(com.upb.agripos.Product p) { items.add(p); }
    public void removeProduct(com.upb.agripos.Product p) { items.remove(p); }

    public double getTotal() {
        double sum = 0;
        for (com.upb.agripos.Product p : items) {
            sum += p.getPrice();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("Isi Keranjang:");
        for (com.upb.agripos.Product p : items) {
            System.out.println("- " + p.getCode() + " " + p.getName() + " = " + p.getPrice());
        }
        System.out.println("Total: " + getTotal());
    }
}