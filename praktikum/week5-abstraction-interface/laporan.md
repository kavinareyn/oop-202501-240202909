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
