package com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {
        System.out.println("Hello, I am Kavina Reyna -240202909 (Week7)");

        com.upb.agripos.Product p1 = new com.upb.agripos.Product("P01", "Beras", 50000);
        com.upb.agripos.Product p2 = new com.upb.agripos.Product("P02", "Pupuk", 30000);

        com.upb.agripos.ShoppingCart cart = new com.upb.agripos.ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.printCart();

        cart.removeProduct(p1);
        cart.printCart();
    }
}