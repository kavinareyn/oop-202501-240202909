package com.upb.agripos;

import com.upb.agripos.model.*;

public class MainPolymorphism {
    public static void main(String[] args) {
        com.upb.agripos.model.Produk[] daftarProduk = {
                new com.upb.agripos.model.Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64"),
                new week4.Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea"),
                new week4.AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja")
        };

        for (com.upb.agripos.model.Produk p : daftarProduk) {
            System.out.println(p.getInfo()); // Dynamic Binding
        }

        com.upb.agripos.util.CreditBy.print("240202909", "Kavina Reyna Riyadi");
    }
}