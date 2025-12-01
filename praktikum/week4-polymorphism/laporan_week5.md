# Laporan Praktikum Minggu 4
Topik: Polymorphism (Info Produk)

## Identitas
- Nama  : Kavina Reyna Riyadi
- NIM   : 240202909
- Kelas : 3ikka

---

## Tujuan
Mahasiswa mampu menjelaskan konsep polymorphism dalam OOP.
Mahasiswa mampu membedakan method overloading dan overriding.
Mahasiswa mampu mengimplementasikan polymorphism (overriding, overloading, dynamic binding) dalam program.
Mahasiswa mampu menganalisis contoh kasus polymorphism pada sistem nyata (Agri-POS).
---

## Dasar Teori
Polymorphism berarti “banyak bentuk” dan memungkinkan objek yang berbeda merespons panggilan method yang sama dengan cara yang berbeda.

Overloading → mendefinisikan method dengan nama sama tetapi parameter berbeda.
Overriding → subclass mengganti implementasi method dari superclass.
Dynamic Binding → pemanggilan method ditentukan saat runtime, bukan compile time.
Dalam konteks Agri-POS, misalnya:

Method getInfo() pada Produk dioverride oleh Benih, Pupuk, AlatPertanian untuk menampilkan detail spesifik.
Method tambahStok() bisa dibuat overload dengan parameter berbeda (int, double).
---

## Langkah Praktikum
1.Overloading
Tambahkan method tambahStok(int jumlah) dan tambahStok(double jumlah) pada class Produk.
2.Overriding
Tambahkan method getInfo() pada superclass Produk.
Override method getInfo() pada subclass Benih, Pupuk, dan AlatPertanian.
3.Dynamic Binding
Buat array Produk[] daftarProduk yang berisi objek Benih, Pupuk, dan AlatPertanian.
Loop array tersebut dan panggil getInfo(). Perhatikan bagaimana Java memanggil method sesuai jenis objek aktual.
4.Main Class
Buat MainPolymorphism.java untuk mendemonstrasikan overloading, overriding, dan dynamic binding.
5.CreditBy
Tetap panggil CreditBy.print("<NIM>", "<Nama>").
Commit dan Push
Commit dengan pesan: week4-polymorphism.
---

## Kode Program
Produk.java
package com.upb.agripos.model;

public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void tambahStok(double jumlah) {
        this.stok += (int) jumlah;
    }

    public String getInfo() {
        return "Produk: " + nama + " (Kode: " + kode + ")";
    }
}

Benih.java

package com.upb.agripos.model;

public class Benih extends Produk {
    private String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    @Override
    public String getInfo() {
        return "Benih: " + super.getInfo() + ", Varietas: " + varietas;
    }
}


MainPolymorphism.java
package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy;

public class MainPolymorphism {
    public static void main(String[] args) {
        Produk[] daftarProduk = {
            new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64"),
            new Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea"),
            new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja")
        };

        for (Produk p : daftarProduk) {
            System.out.println(p.getInfo()); // Dynamic Binding
        }

        CreditBy.print("<NIM>", "<Nama Mahasiswa>");
    }
}

---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)
---

## Analisis
Pada praktikum ini, polymorphism diterapkan melalui overloading, overriding, dan dynamic binding. Method tambahStok() dibuat overload agar dapat menerima tipe parameter berbeda. Method getInfo() dioverride pada setiap subclass sehingga masing-masing produk menampilkan informasi spesifik. Dynamic binding terlihat ketika array Produk[] di-loop dan Java memanggil getInfo() sesuai jenis objek sebenarnya, bukan tipe referensinya. Kendala yang muncul adalah error cannot find symbol pada class Pupuk, yang disebabkan file belum dibuat atau salah package, dan diperbaiki dengan memastikan semua class berada di folder com.upb.agripos.model.
---

## Kesimpulan
Praktikum ini menunjukkan bahwa polymorphism membuat program lebih fleksibel, karena method yang sama dapat berperilaku berbeda pada tiap objek. Overloading, overriding, dan dynamic binding membantu membuat sistem lebih modular, mudah dikembangkan, dan sesuai kebutuhan tiap jenis produk.
---

## Quiz
1. Apa perbedaan overloading dan overriding?  
   **Jawaban:** Terjadi di dalam class yang sama.
Method namanya sama, tapi parameternya berbeda (jumlah atau tipe).
Tujuannya memberi cara pemanggilan berbeda untuk fungsi yang mirip.
Ciri:
Antar class dengan hubungan inheritance
Nama, parameter, return sama
Ada anotasi @Override

2. Bagaimana Java menentukan method mana yang dipanggil dalam dynamic binding?  
   **Jawaban:** 
Cara Java Menentukan Method (Dynamic Binding)
1.Lihat tipe objek sebenarnya (real object), bukan tipe referensi.
Meskipun variabelnya bertipe superclass, Java akan melihat objek yang dibuat.
2.Cari method yang dioverride di subclass.
Jika subclass punya method yang sama (overriding), maka itu yang dipanggil.
3.Pemilihan dilakukan saat runtime, bukan saat compile.

3. Berikan contoh kasus polymorphism dalam sistem POS selain produk pertanian. 
   **Jawaban:** sistem pos restoran, minimarket/retail, toko baju, toko buku
