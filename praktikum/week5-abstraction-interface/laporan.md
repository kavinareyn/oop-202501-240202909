#Laporan Praktikum Minggu 5
Topik: Abstraction (Abstract Class & Interface)

## Identitas
- Nama  : Kavina Reyna Riyadi
- NIM   : 240202909
- Kelas : 3IKKA

---

## Tujuan
Mahasiswa mampu menjelaskan perbedaan abstract class dan interface, mendesain abstract class dengan method abstrak, dan membuat interface serta menerapkan multiple inheritance melalui interface pada rancangan kelas.

---

## Dasar Teori
Abstraksi: Proses menyederhanakan kompleksitas dengan menampilkan elemen penting dan menyembunyikan detail implementasi.
Abstract Class: Tidak dapat diinstansiasi, dapat memiliki method abstrak (tanpa badan) dan non-abstrak, serta dapat menyimpan state (field).
Interface: Kumpulan kontrak (method tanpa implementasi konkret). Mendukung multiple inheritance (class dapat mengimplementasikan banyak interface).
Multiple Inheritance via Interface: Memungkinkan sebuah class mewarisi perilaku (kontrak) dari dua atau lebih sumber, yang lebih aman di Java daripada mewarisi state dari banyak class.

---

## Langkah Praktikum
Abstract Class: Membuat Pembayaran.java (abstract) dengan method abstrak (biaya(), prosesPembayaran()) dan method konkrit (totalBayar()).
Subclass Konkret: Membuat Cash.java dan EWallet.java yang mewarisi Pembayaran dan mengimplementasikan semua method abstrak.
Interface: Membuat Validatable.java dan Receiptable.java (kontrak).
Multiple Inheritance: Menerapkan EWallet agar mengimplementasikan dua interface (Validatable, Receiptable), dan Cash mengimplementasikan Receiptable.
Commit Message: week5-abstraction-interface.

---

## Kode Program
receiptable.java
package com.upb.agripos.model.kontrak;

public interface Receiptable {
    String cetakStruk();
}

validatable.java
package com.upb.agripos.model.kontrak;

public interface Validatable {
    boolean validasi(); // misal validasi OTP/ PIN
}

cash.java
package com.upb.agripos.model.pembayaran;

import com.upb.agripos.model.kontrak.Receiptable;

public class Cash extends com.upb.agripos.model.pembayaran.Pembayaran implements Receiptable {
    private double tunai;

    public Cash(String invoiceNo, double total, double tunai) {
        super(invoiceNo, total);
        this.tunai = tunai;
    }

    @Override
    public double biaya() {
        return 0.0;
    }

    @Override
    public boolean prosesPembayaran() {
        return tunai >= totalBayar(); // sederhana: cukup uang tunai
    }

    @Override
    public String cetakStruk() {
        return String.format("INVOICE %s | TOTAL: %.2f | BAYAR CASH: %.2f | KEMBALI: %.2f",
                invoiceNo, totalBayar(), tunai, Math.max(0, tunai - totalBayar()));
    }
}

ewallet.java
package com.upb.agripos.model.pembayaran;

import com.upb.agripos.model.kontrak.Validatable;
import com.upb.agripos.model.kontrak.Receiptable;

public class EWallet extends Pembayaran implements Validatable, Receiptable {
    private String akun;
    private String otp; // sederhana untuk simulasi

    public EWallet(String invoiceNo, double total, String akun, String otp) {
        super(invoiceNo, total);
        this.akun = akun;
        this.otp = otp;
    }

    @Override
    public double biaya() {
        return total * 0.015; // 1.5% fee
    }

    @Override
    public boolean validasi() {
        return otp != null && otp.length() == 6; // contoh validasi sederhana
    }

    @Override
    public boolean prosesPembayaran() {
        return validasi(); // jika validasi lolos, anggap berhasil
    }

    @Override
    public String cetakStruk() {
        return String.format("INVOICE %s | TOTAL+FEE: %.2f | E-WALLET: %s | STATUS: %s",
                invoiceNo, totalBayar(), akun, prosesPembayaran() ? "BERHASIL" : "GAGAL");
    }
}

pembayaran.java
package com.upb.agripos.model.pembayaran;

public abstract class Pembayaran {
    protected String invoiceNo;
    protected double total;

    public Pembayaran(String invoiceNo, double total) {
        this.invoiceNo = invoiceNo;
        this.total = total;
    }

    public abstract double biaya();               // fee/biaya tambahan
    public abstract boolean prosesPembayaran();   // proses spesifik tiap metode

    public double totalBayar() {
        return total + biaya();
    }

    public String getInvoiceNo() { return invoiceNo; }
    public double getTotal() { return total; }
}

creditby.java
package com.upb.agripos.util;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\ncredit by: " + nim + " - " + nama);
    }
}
mainabstraction.java
package com.upb.agripos;

import com.upb.agripos.model.pembayaran.*;
import com.upb.agripos.model.kontrak.*;
import com.upb.agripos.util.CreditBy;

public class MainAbstraction {
    public static void main(String[] args) {
        com.upb.agripos.model.pembayaran.Pembayaran cash = new com.upb.agripos.model.pembayaran.Cash("INV-001", 100000, 120000);
        com.upb.agripos.model.pembayaran.Pembayaran ew = new com.upb.agripos.model.pembayaran.EWallet("INV-002", 150000, "user@ewallet", "123456");

        System.out.println(((com.upb.agripos.model.kontrak.Receiptable) cash).cetakStruk());
        System.out.println(((com.upb.agripos.model.kontrak.Receiptable) ew).cetakStruk());

        CreditBy.print("240202909", "Kavina Reyna Riyadi");
    }
}

---

## Hasil Eksekusi

---

## Analisis

Program ini berhasil menerapkan abstraction dan interface dalam Java untuk membangun sistem pembayaran yang fleksibel. Dengan memisahkan kontrak, logika umum, dan implementasi spesifik, sistem menjadi mudah dikembangkan dan dipelihara.
---

## Kesimpulan
Program ini menerapkan konsep abstraction, interface, dan polymorphism pada Java untuk membangun sistem pembayaran sederhana. Abstract class Pembayaran menjadi dasar umum, sedangkan Cash dan EWallet mengimplementasikan proses pembayaran sesuai karakteristik masing-masing. Struktur program yang modular membuat sistem mudah dikembangkan dan dipelihara.
---

## Quiz
1. Perbedaan aggregation dan composition? 
   **Jawaban:**  Aggregation -> hubungan lemah (weak has-a). Objek bisa berdiri sendiri tanpa objek induknya. Composition hubungan kuat (strong has-a) objek bagian tidak bisa hidup tanpa objek induk.

2. Bagaimana prinsip Open/Closed membantu pengembangan sistem?
   **Jawaban:** Prinsip Open/Closed membantu pengembangan sistem dengan cara membuat sistem terbuka untuk penambahan fitur, tetapi tertutup untuk perubahan kode lama.
Artinya, fitur baru bisa ditambahkan (misalnya metode pembayaran baru) tanpa mengubah kode yang sudah ada, sehingga sistem lebih aman, fleksibel, dan mudah dikembangkan.

3. Mengapa Dependency Inversion Principle meningkatkan testability? 
   **Jawaban:** Dependency Inversion Principle (DIP) meningkatkan testability karena kelas bergantung pada abstraksi (interface/abstract class), bukan pada implementasi konkret.

Akibatnya, saat pengujian kita bisa mengganti dependensi asli dengan mock atau dummy object, sehingga pengujian menjadi lebih mudah, terisolasi, dan tidak bergantung pada sistem nyata (seperti database atau API).
