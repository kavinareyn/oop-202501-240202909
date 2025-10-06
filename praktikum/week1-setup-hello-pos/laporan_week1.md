# Laporan Praktikum Minggu 1
Topik: Pengenalan Paradigma dan Setup Proyek

## Identitas
- Nama  : Kavina Reyna Riyadi
- NIM   : 240202909
- Kelas : 3IKKA

---

## Tujuan
Mahasiswa mampu mendefinisikan paradigma prosedural, OOP, dan fungsional.
Mahasiswa mampu membandingkan kelebihan dan keterbatasan tiap paradigma.
Mahasiswa mampu memberikan contoh program sederhana untuk masing-masing paradigma.
Mahasiswa aktif dalam diskusi kelas (bertanya, menjawab, memberi opini).
---

## Dasar Teori
Paradigma pemrograman adalah cara pandang dalam menyusun program:

Prosedural: program dibangun sebagai rangkaian perintah (fungsi/prosedur).
OOP (Object-Oriented Programming): program dibangun dari objek yang memiliki data (atribut) dan perilaku (method).
Fungsional: program dipandang sebagai pemetaan fungsi matematika, lebih menekankan ekspresi dan transformasi data.
---

## Langkah Praktikum
1. Setup Project
Pastikan sudah menginstall JDK (Java Development Kit), IDE (misal: IntelliJ IDEA, VS Code, NetBeans), Git, PostgreSQL, dan JavaFX di komputer.
Buat folder project oop-pos-<nim>.
Inisialisasi repositori Git.
Buat struktur awal src/main/java/com/upb/agripos/.
Pastikan semua tools dapat berjalan (uji dengan membuat dan menjalankan program Java sederhana).

2. Program Sederhana dalam 3 Paradigma
Prosedural: program untuk menghitung total harga dua produk.
OOP: class Produk dengan atribut nama dan harga, buat minimal tiga objek, lalu hitung total.
Fungsional: gunakan Stream atau lambda untuk menghitung total harga dari minimal tiga objek.

3. Commit dan Push
Commit dengan pesan: week1-setup-hello-pos.


---

## Kode Program
(Tuliskan kode utama yang dibuat, contoh:  

1. HelloProcedural.java
package com.upb.agripos;

public class HelloProcedural {
    public static void main(String[] args) {
        String nim = "240202909";
        String nama = "Kavina Reyna Riyadi";
        String[] produk = {"Beras", "Pupuk", "Benih"};
        int[] harga = {10000, 15000, 12000};
        int total = 0;

        System.out.println("Hello POS World");
        System.out.println("NIM: " + nim + ", Nama: " + nama);
        System.out.println("Daftar Produk:");
        for (int i = 0; i < produk.length; i++) {
            System.out.println("- " + produk[i] + ": " + harga[i]);
            total += harga[i];
        }
        System.out.println("Total harga semua produk: " + total);
    }
}

2. HelloOOP.java
class Produk {
    String nama;
    int harga;
    Produk(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }
}

public class HelloOOP {
    public static void main(String[] args) {
        String nim = "240202909";
        String namaMhs = "Kavina Reyna Riyadi";
        Produk[] daftar = {
                new Produk("Beras", 10000),
                new Produk("Pupuk", 15000),
                new Produk("Benih", 12000)
        };
        int total = 0;
        System.out.println("Hello POS World");
        System.out.println("NIM: " + nim + ", Nama: " + namaMhs);
        System.out.println("Daftar Produk:");
        for (Produk p : daftar) {
            System.out.println("- " + p.nama + ": " + p.harga);
            total += p.harga;
        }
        System.out.println("Total harga semua produk: " + total);
    }
}

3. HelloFunctional.java
import java.util.*;
import java.util.stream.*;
public class HelloFunctional {
    public static void main(String[] args) {
        String nim = "240202909";
        String nama = "Kavina Reyna Riyadi";
        List<String> produk = Arrays.asList("Beras", "Pupuk", "Benih");
        List<Integer> harga = Arrays.asList(10000, 15000, 12000);
        System.out.println("Hello POS World");
        System.out.println("NIM: " + nim + ", Nama: " + nama);
        System.out.println("Daftar Produk:");
        IntStream.range(0, produk.size())
                .forEach(i -> System.out.println("- " + produk.get(i) + ": " + harga.get(i)));
        int total = harga.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total harga semua produk: " + total);
    }
}

## Hasil Eksekusi
praktikum/week1-setup-hello-pos/screenshots/HelloFuctional.png
praktikum/week1-setup-hello-pos/screenshots/HelloOOP.png
praktikum/week1-setup-hello-pos/screenshots/HelloProcedural.png

## Analisis
1. HelloProcedural.java
program ini dibuat dengan pemrograman procedural yang dieksekusi berurutan dalam satu fungsi utama. Program ini menggunakan variable, array, dan perulangan untuk menampilkan daftar produk, harga dan menghitung totalnya

2. HelloOOP.java
Program ini membuat kelas Produk yang memiliki atribut (nama, harga) dan konstruktor untuk inisialisasi data.
Dalam main, objek-objek Produk dibuat dan disimpan dalam array, lalu datanya ditampilkan melalui iterasi.

3. HelloFunctional.java
Program menggunakan pemrograman fungsional, yang menekankan penggunaan fungsi murni, stream, dan operasi deklaratif.
Program ini memanfaatkan IntStream dan stream() untuk mengelola dan menghitung data secara lebih ringkas dan ekspresif.


## Kesimpulan
Paradigma prosedural cocok untuk program sederhana,
OOP cocok untuk aplikasi besar dan kompleks,
Fungsional cocok untuk pemrosesan data modern yang efisien dan bersih.
---

## Quiz
1. Apakah OOP selalu lebih baik dari prosedural? 
   **Jawaban:** Tidak selalu. OOP lebih baik digunakan untuk program besar dan kompleks karena menyediakan struktur modular dan reusabilitas kode melalui kelas dan objek.
Namun, untuk program kecil dan sederhana, paradigma prosedural bisa lebih cepat dikembangkan dan mudah dipahami, karena tidak memerlukan struktur kelas yang kompleks.

2. Kapan functional programming lebih cocok digunakan dibanding OOP atau prosedural?  
   **Jawaban:** Functional programming lebih cocok ketika program berfokus pada pengolahan data, seperti filtering, mapping, dan agregasi. Dibutuhkan kode ringkas dan deklaratif, misalnya pada analisis data, stream processing, atau program reaktif. Menghindari perubahan state dan efek samping penting, misalnya pada sistem paralel atau multithreading.

3. Bagaimana paradigma memengaruhi maintainability dan scalability aplikasi?  
   **Jawaban:** Prosedural sulit dimaintain jika program besar karena logika bercampur dalam satu fungsi yang sama dan skalabilitasnya rendah.
OOP sangar mendukung maintainability karena kode terstruktur dalam class dan object, skalabilitas tinggi
Fungsional kode lebih bersih dan modular, mudah diuji dan diparalelkan, cocok untuk aplikasi berskala besar yang butuh efisiensi dan konsistensi.

4. Mengapa OOP lebih cocok untuk mengembangkan aplikasi POS dibanding prosedural?
   **Jawaban:**  Aplikasi POS (Point of Sale) terdiri dari banyak entitas seperti Produk, Transaksi, Pelanggan, dan Kasir.
Dengan OOP, setiap entitas bisa dibuat sebagai kelas dengan atribut dan method sendiri, sehingga kode lebih terorganisir, mudah dikembangkan saat fitur baru ditambah, lebih realistis dalam memodelkan dunia nyata sedangkan pendekatan prosedural akan membuat kode berulang dan sulit dikelola jika kompleksitas meningkat.

5. Bagaimana paradigma fungsional dapat membantu mengurangi kode berulang (boilerplate code)? 
   **Jawaban:** Functional programming menggunakan fungsi murni, stream, dan lambda expression yang memungkinkan operasi kompleks dilakukan dalam satu baris kode. Contohnya, operasi seperti menghitung total, filter, dan transformasi data bisa dilakukan tanpa loop eksplisit. Hal ini mengurangi boilerplate (kode perulangan dan deklarasi berulang) serta membuat kode lebih singkat, ekspresif, dan mudah dirawat.
