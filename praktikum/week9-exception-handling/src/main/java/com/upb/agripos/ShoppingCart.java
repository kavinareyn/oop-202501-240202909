package com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<com.upb.agripos.Product, Integer> items = new HashMap<>();

    public void addProduct(com.upb.agripos.Product p, int qty) throws com.upb.agripos.InvalidQuantityException {
        if (qty <= 0) {
            throw new com.upb.agripos.InvalidQuantityException("Quantity harus lebih dari 0.");
        }
        items.put(p, items.getOrDefault(p, 0) + qty);
    }

    public void removeProduct(com.upb.agripos.Product p) throws com.upb.agripos.ProductNotFoundException {
        if (!items.containsKey(p)) {
            throw new com.upb.agripos.ProductNotFoundException("Produk tidak ada dalam keranjang.");
        }
        items.remove(p);
    }

    public void checkout() throws com.upb.agripos.InsufficientStockException {
        for (Map.Entry<com.upb.agripos.Product, Integer> entry : items.entrySet()) {
            com.upb.agripos.Product product = entry.getKey();
            int qty = entry.getValue();
            if (product.getStock() < qty) {
                throw new com.upb.agripos.InsufficientStockException(
                        "Stok tidak cukup untuk: " + product.getName()
                );
            }
        }
        // contoh pengurangan stok bila semua cukup
        for (Map.Entry<com.upb.agripos.Product, Integer> entry : items.entrySet()) {
            entry.getKey().reduceStock(entry.getValue());
        }
    }
}