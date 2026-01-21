# Laporan Praktikum Minggu 7
Topik: Collections dan Implementasi Keranjang Belanja

## Identitas
- Nama  : Kavina Reyna Riyadi
- NIM   : 240202909
- Kelas : 3ikka

---

## Tujuan
Mahasiswa mampu:

Menjelaskan konsep collection dalam Java (List, Map, Set).
Menggunakan ArrayList untuk menyimpan dan mengelola objek.
Mengimplementasikan Map atau Set sesuai kebutuhan pengelolaan data.
Melakukan operasi dasar pada collection: tambah, hapus, dan hitung total.
Menganalisis efisiensi penggunaan collection dalam konteks sistem Agri-POS.

---

## Dasar Teori
1. Collections Framework
Java Collections Framework menyediakan struktur data untuk mengelola objek secara dinamis dan efisien.

Struktur utama:

List (implementasi: ArrayList) — Terurut, dapat menyimpan elemen duplikat.
Map (implementasi: HashMap) — Menyimpan pasangan key–value, akses cepat berdasarkan key.
Set (implementasi: HashSet) — Tidak menerima duplikat dan tidak mempertahankan urutan.

2. Studi Kasus: Keranjang Belanja Agri-POS
Keranjang belanja harus dapat:

Menambahkan produk
Menghapus produk
Menampilkan isi keranjang
Menghitung total nilai transaksi
Menangani jumlah (quantity) menggunakan Map
Kasus ini mencerminkan penggunaan struktur data dalam aplikasi nyata seperti POS.



---

## Langkah Praktikum
1. Membuat Class Product
2. Implementasi Keranjang dengan ArrayList
3. Main Program
4. Implementasi Alternatif Menggunakan Map (Dengan Quantity)
---

## Kode Program
maincart.java

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

product.java

package com.upb.agripos;

public class Product {
    private final String code;
    private final String name;
    private final double price;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}

shoppingcart.java
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

shoppingcartmap.java
package com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartMap {
    private final Map<com.upb.agripos.Product, Integer> items = new HashMap<>();

    public void addProduct(com.upb.agripos.Product p) { items.put(p, items.getOrDefault(p, 0) + 1); }

    public void removeProduct(com.upb.agripos.Product p) {
        if (!items.containsKey(p)) return;
        int qty = items.get(p);
        if (qty > 1) items.put(p, qty - 1);
        else items.remove(p);
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<com.upb.agripos.Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void printCart() {
        System.out.println("Isi Keranjang (Map):");
        for (Map.Entry<com.upb.agripos.Product, Integer> e : items.entrySet()) {
            System.out.println("- " + e.getKey().getCode() + " " + e.getKey().getName() + " x" + e.getValue());
        }
        System.out.println("Total: " + getTotal());
    }
}


---

## Hasil Eksekusi


## Analisis
Program ini menerapkan Java Collections Framework untuk mengelola data keranjang belanja pada sistem Agri-POS. Struktur ArrayList digunakan pada ShoppingCart untuk menyimpan daftar produk secara terurut dan sederhana, cocok untuk kasus tanpa pengelolaan jumlah barang. Operasi dasar seperti menambah, menghapus, dan menghitung total transaksi dilakukan dengan iterasi elemen list.

Sebagai alternatif, kelas ShoppingCartMap menggunakan HashMap untuk menyimpan pasangan produk–jumlah (quantity). Pendekatan ini lebih efisien dalam menangani produk yang sama dengan jumlah lebih dari satu, serta mempermudah penghitungan total berdasarkan kuantitas. Perbandingan ini menunjukkan bagaimana pemilihan collection yang tepat dapat meningkatkan efisiensi dan kejelasan logika program.

---

## Kesimpulan
Penggunaan collection dalam Java mempermudah pengelolaan data secara dinamis pada sistem Agri-POS. ArrayList cocok untuk keranjang sederhana, sedangkan Map lebih efektif untuk pengelolaan produk dengan jumlah. Pemilihan struktur data yang tepat membantu meningkatkan efisiensi, keterbacaan, dan fleksibilitas program.

---

## Quiz
1. Jelaskan perbedaan mendasar antara List, Map, dan Set. 
   **Jawaban:** List: data berurutan, boleh duplikat
Set: tidak berurutan, tidak boleh duplikat
Map: pasangan key–value, key harus unik

2. Mengapa ArrayList cocok digunakan untuk keranjang belanja sederhana? 
   **Jawaban:**  Karena mudah digunakan, terurut, dan cocok untuk menambah serta menghapus item tanpa mengelola jumlah.

3. Bagaimana struktur Set mencegah duplikasi data?
   **Jawaban:** Karena Set hanya menyimpan elemen unik dan menolak elemen yang sama
   
4. Kapan sebaiknya menggunakan Map dibandingkan List? Jelaskan dengan contoh.
   **Jawaban:** Saat data memiliki key khusus, misalnya produk sebagai key dan jumlah sebagai value (Produk → Quantity).
