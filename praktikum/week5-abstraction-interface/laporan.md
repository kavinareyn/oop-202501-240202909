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

Program ini menerapkan konsep abstraction menggunakan abstract class dan interface pada Java. Abstract class Pembayaran digunakan sebagai kerangka dasar untuk semua metode pembayaran karena memiliki atribut dan perilaku umum, sedangkan interface Validatable dan Receiptable digunakan untuk mendefinisikan kemampuan tambahan seperti validasi dan pencetakan struk. Implementasi pada kelas Cash dan EWallet menunjukkan penerapan polimorfisme dan multiple inheritance melalui interface, sehingga sistem menjadi fleksibel, terstruktur, dan mudah dikembangkan.
---

## Kesimpulan
Program ini menunjukkan penerapan abstraction menggunakan abstract class dan interface dalam Java untuk membangun sistem pembayaran yang terstruktur. Abstract class Pembayaran menangani perilaku umum, sedangkan interface digunakan untuk menambahkan kemampuan khusus seperti validasi dan pencetakan struk. Pendekatan ini membuat sistem lebih fleksibel, mudah dikembangkan, dan mudah dipelihara.
---

## Quiz
1. Jelaskan perbedaan konsep dan penggunaan abstract class dan interface

Jawaban:
Abstract class digunakan untuk kelas dasar yang memiliki atribut dan perilaku umum, sedangkan interface digunakan untuk mendefinisikan kontrak atau kemampuan yang harus dimiliki oleh suatu kelas tanpa terikat hierarki.

2. Mengapa multiple inheritance lebih aman dilakukan dengan interface pada Java?

Jawaban:
Karena interface tidak memiliki state dan implementasi kompleks, sehingga menghindari konflik dan ambiguitas yang dapat terjadi pada multiple inheritance class.

3. Pada contoh Agri-POS, bagian mana yang paling tepat menjadi abstract class dan interface? Jelaskan alasannya.

Jawaban:
Pembayaran paling tepat menjadi abstract class karena menyimpan data dan logika umum, sedangkan Validatable dan Receiptable tepat menjadi interface karena merepresentasikan kemampuan tambahan yang dapat dimiliki oleh berbagai metode pembayaran.
