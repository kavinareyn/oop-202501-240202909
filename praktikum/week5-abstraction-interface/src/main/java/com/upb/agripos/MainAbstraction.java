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