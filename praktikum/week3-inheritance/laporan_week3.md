# Laporan Praktikum Minggu 3
Topik: Inheritance (Kategori Produk)

## Identitas
- Nama  : Kavina Reyna Riyadi
- NIM   : 240202909
- Kelas : 3IKKA

---

## Tujuan
Mahasiswa mampu menjelaskan konsep inheritance (pewarisan class) dalam OOP.
Mahasiswa mampu membuat superclass dan subclass untuk produk pertanian.
Mahasiswa mampu mendemonstrasikan hierarki class melalui contoh kode.
Mahasiswa mampu menggunakan super untuk memanggil konstruktor dan method parent class.
Mahasiswa mampu membuat laporan praktikum yang menjelaskan perbedaan penggunaan inheritance dibanding class tunggal.

## Dasar Teori
Inheritance adalah mekanisme dalam OOP yang memungkinkan suatu class mewarisi atribut dan method dari class lain.

Superclass: class induk yang mendefinisikan atribut umum.
Subclass: class turunan yang mewarisi atribut/method superclass, dan dapat menambahkan atribut/method baru.
super digunakan untuk memanggil konstruktor atau method superclass.
Dalam konteks Agri-POS, kita dapat membuat class Produk sebagai superclass, kemudian Benih, Pupuk, dan AlatPertanian sebagai subclass. Hal ini membuat kode lebih reusable dan terstruktur.
---

## Langkah Praktikum
1. Membuat Superclass Produk
Gunakan class Produk dari Bab 2 sebagai superclass.
2. Membuat Subclass
Benih.java → atribut tambahan: varietas.
Pupuk.java → atribut tambahan: jenis pupuk (Urea, NPK, dll).
AlatPertanian.java → atribut tambahan: material (baja, kayu, plastik).
3. Membuat Main Class
Instansiasi minimal satu objek dari tiap subclass.
Tampilkan data produk dengan memanfaatkan inheritance.
4. Menambahkan CreditBy
Panggil class CreditBy untuk menampilkan identitas mahasiswa.
5. Commit dan Push
Commit dengan pesan: week3-inheritance.

---

## Kode Program
Alat Pertanian
package com.upb.agripos.model;

public class AlatPertanian extends com.upb.agripos.model.Produk {
    private String material;

    public AlatPertanian(String kode, String nama, double harga, int stok, String material) {
        super(kode, nama, harga, stok);
        this.material = material;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
}
Benih
package com.upb.agripos.model;

public class Benih extends com.upb.agripos.model.Produk {
    private String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    public String getVarietas() { return varietas; }
    public void setVarietas(String varietas) { this.varietas = varietas; }
}

Pupuk
package com.upb.agripos.model;

public class Pupuk extends com.upb.agripos.model.Produk {
    private String jenis;

    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }
}

MainInheritage
package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy;

public class MainInheritance {
    public static void main(String[] args) {
        Benih b = new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64");
        Pupuk p = new Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea");
        AlatPertanian a = new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja");

        System.out.println("Benih: " + b.getNama() + " Varietas: " + b.getVarietas());
        System.out.println("Pupuk: " + p.getNama() + " Jenis: " + p.getJenis());
        System.out.println("Alat Pertanian: " + a.getNama() + " Material: " + a.getMaterial());

        CreditBy.print("240202909", "Kavina Reyna Riyadi");
    }
}

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)
---

## Analisis

Pada praktikum ini digunakan konsep inheritance untuk membuat satu class induk (Produk) yang menyimpan atribut umum seperti kode, nama, harga, dan stok. Tiga class turunan (Benih, Pupuk, AlatPertanian) mewarisi atribut tersebut sehingga tidak perlu menulis ulang di setiap class. Setiap subclass juga menambahkan atribut khusus sesuai jenis produknya.

Pemanggilan super() digunakan agar constructor subclass tetap mengisi data milik class induk. Dari hasil running, terlihat bahwa setiap objek subclass dapat mengakses atribut dari Produk, yang berarti pewarisan berjalan dengan benar. Penggunaan inheritance membuat kode lebih rapi dan lebih mudah dikembangkan dibanding membuat satu class besar.
---

## Kesimpulan
Dari praktikum ini dapat disimpulkan bahwa:
Inheritance memudahkan pengembangan sistem dengan memisahkan atribut umum ke dalam superclass dan atribut khusus ke dalam subclass.
Pewarisan membuat kode lebih ringkas, terstruktur, dan reusable, karena bagian umum tidak perlu ditulis berulang pada setiap class.
Penggunaan super() sangat penting untuk memastikan konstruktor subclass tetap menginisialisasi atribut milik superclass.
Hierarki class memudahkan pengelompokan kategori produk seperti Benih, Pupuk, dan Alat Pertanian, sehingga sistem lebih mudah dikembangkan.
Dibandingkan class tunggal, pendekatan inheritance lebih fleksibel dan efisien, terutama ketika sistem tumbuh dan membutuhkan penambahan kategori baru.---

## Quiz
1. Apa keuntungan menggunakan inheritance dibanding membuat class terpisah tanpa hubungan?
**Jawaban:** Menghindari duplikasi kode (reusable).
Struktur program lebih rapi dan terorganisir.
Mudah dikembangkan ketika menambah kategori baru.
Konsistensi atribut dan method lebih terjaga.
Perubahan pada superclass otomatis berlaku ke subclass.
Membentuk hierarki class yang jelas.
Mendukung polimorfisme

2. Bagaimana cara subclass memanggil konstruktor superclass?
**Jawaban:** Subclass memanggil konstruktor superclass dengan menggunakan keyword super() pada baris pertama konstruktor subclass.

3. Berikan contoh kasus di POS pertanian selain Benih, Pupuk, dan Alat Pertanian yang bisa dijadikan subclass.
**Jawaban:** obat tanaman, media tanam, alat irigasi seperti selang, pot, perlengkapan panen.