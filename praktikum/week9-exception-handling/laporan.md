# Laporan Praktikum Minggu 9
Topik: Exception Handling, Custom Exception, dan Penerapan Design Pattern

## Identitas
- Nama  : Kavina Reyna Riyadi
- NIM   : 240202909
- Kelas : 3IKKA

---

## Tujuan
Mahasiswa mampu:

Menjelaskan perbedaan antara error dan exception.
Mengimplementasikan try–catch–finally dengan tepat.
Membuat custom exception sesuai kebutuhan program.
Mengintegrasikan exception handling ke dalam aplikasi sederhana (kasus keranjang belanja).
(Opsional) Menerapkan design pattern sederhana (Singleton/MVC) dan unit testing dasar.

---

## Dasar Teori
1. Error vs Exception
Error → kondisi fatal, tidak dapat ditangani (contoh: OutOfMemoryError).
Exception → kondisi tidak normal yang dapat ditangani oleh program.
2. Struktur try–catch–finally
try {
    // kode yang berpotensi menimbulkan kesalahan
} catch (Exception e) {
    // penanganan
} finally {
    // blok yang selalu dijalankan
}
3. Membuat Custom Exception
package com.upb.agripos;

public class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}
Studi Kasus Agri-POS: Keranjang Belanja
Keranjang belanja harus memvalidasi:

Jumlah pembelian > 0
Produk ada dalam keranjang
Stok mencukupi
Kesalahan–kesalahan tersebut ditangani menggunakan custom exception.



---

## Langkah Praktikum
1. Membuat Custom Exception
2. Model Product dengan Stok
3. Implementasi ShoppingCart dengan Exception Handling
4. Main Program untuk Menguji Exception Handling
---

## Kode Program
''insufficientStockException
package com.upb.agripos;

public class InsufficientStockException extends Exception {
    public InsufficientStockException(String msg) { super(msg); }
}

InvalidQuantityException
package com.upb.agripos;

public class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String msg) { super(msg); }
}
MainEXceptionDemo
package com.upb.agripos;

public class MainExceptionDemo {
    public static void main(String[] args) {
        System.out.println("Hello, I am Kavina Reyna Riyadi-240202909 (Week9)");

        com.upb.agripos.ShoppingCart cart = new com.upb.agripos.ShoppingCart();
        com.upb.agripos.Product p1 = new com.upb.agripos.Product("P01", "Pupuk Organik", 25000, 3);

        try {
            cart.addProduct(p1, -1);
        } catch (com.upb.agripos.InvalidQuantityException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }

        try {
            cart.removeProduct(p1);
        } catch (com.upb.agripos.ProductNotFoundException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }

        try {
            cart.addProduct(p1, 5);
            cart.checkout();
        } catch (Exception e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }
    }
}

Product
package com.upb.agripos;

public class Product {
    private final String code;
    private final String name;
    private final double price;
    private int stock;

    public Product(String code, String name, double price, int stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public void reduceStock(int qty) { this.stock -= qty; }
}

ProductNotFoundException
package com.upb.agripos;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String msg) { super(msg); }
}

shoppingcart
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


---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)
---

## Analisis
(
- Jelaskan bagaimana kode berjalan.  
- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.  
- Kendala yang dihadapi dan cara mengatasinya.  
)
---

## Kesimpulan
(Tuliskan kesimpulan dari praktikum minggu ini.  
Contoh: *Dengan menggunakan class dan object, program menjadi lebih terstruktur dan mudah dikembangkan.*)

---

## Quiz
(1. [Tuliskan kembali pertanyaan 1 dari panduan]  
   **Jawaban:** …  

2. [Tuliskan kembali pertanyaan 2 dari panduan]  
   **Jawaban:** …  

3. [Tuliskan kembali pertanyaan 3 dari panduan]  
   **Jawaban:** …  )
