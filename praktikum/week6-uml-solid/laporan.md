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
Menganalisis kebutuhan sistem dari deskripsi awal.
Membuat daftar aktor dan use case.
Menggambar Use Case Diagram sebagai iterasi pertama.
Mendesain Activity Diagram proses checkout lengkap dengan skenario gagal.
Membuat Sequence Diagram untuk pembayaran tunai dan e-wallet.
Mendesain Class Diagram berdasarkan relasi antar objek dan prinsip SOLID.
Menghasilkan file diagram .png dan dokumentasinya.
Menyusun laporan dalam format markdown.

---

## Deskripsi Singkat Sistem
Agri-POS adalah sistem Point of Sale (POS) khusus untuk sektor pertanian yang dirancang untuk mendukung transaksi penjualan produk pertanian seperti benih, pupuk, alat, dan obat-obatan. Sistem ini memungkinkan kasir untuk melakukan transaksi dengan berbagai metode pembayaran, sementara admin dapat mengelola inventori produk dan melihat laporan penjualan. Arsitektur sistem mengadopsi prinsip SOLID untuk memastikan maintainability, extensibility, dan reusability.


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

