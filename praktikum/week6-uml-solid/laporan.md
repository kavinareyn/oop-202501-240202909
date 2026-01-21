# Laporan Praktikum Minggu 6
Topik: Desain Arsitektur Sistem Agri-POS Menggunakan UML & SOLID

## Identitas
- Nama  : Kavina Reyna Riyadi
- NIM   : 240202909
- Kelas : 3IKKA

---

## Tujuan
Praktikum ini bertujuan untuk:

Mahasiswa mampu memetakan kebutuhan sistem menjadi diagram UML.
Mahasiswa mampu membuat Use Case, Activity, Sequence, dan Class Diagram.
Mahasiswa memahami dan menerapkan prinsip desain SOLID.
Mahasiswa mampu menghubungkan kebutuhan fungsional ke desain arsitektur perangkat lunak.

---

## Dasar Teori
UML adalah standar pemodelan yang digunakan untuk menggambarkan desain sistem perangkat lunak.
Dalam praktikum ini digunakan 4 diagram:

Use Case Diagram
Activity Diagram
Sequence Diagram
Class Diagram
2. Prinsip SOLID
S — Single Responsibility Principle
Setiap class hanya memiliki satu alasan untuk berubah.
O — Open/Closed Principle
Kelas terbuka untuk ekstensi, tertutup untuk modifikasi.
L — Liskov Substitution Principle
Subclass harus dapat menggantikan superclass tanpa mengubah perilaku.
I — Interface Segregation Principle
Interface harus spesifik, tidak terlalu gemuk.
D — Dependency Inversion Principle
High-level module harus bergantung pada abstraksi.
---

## Langkah Praktikum
(Tuliskan Langkah-langkah dalam prakrikum, contoh:
1. Langkah-langkah yang dilakukan (setup, coding, run).  
2. File/kode yang dibuat.  
3. Commit message yang digunakan.)

---

## Kode Program
(Tuliskan kode utama yang dibuat, contoh:  

```java
// Contoh
Produk p1 = new Produk("BNH-001", "Benih Padi", 25000, 100);
System.out.println(p1.getNama());
```
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)
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

