package aracSigorta;

import java.util.Scanner;

public class AracSigortaApplication {
    /*
Proje: Araç Sigorta Prim Hesaplama
       Araç tipleri:otomobil, kamyon, otobüs, motosiklet
                    -otobüs: 18-30 koltuk veya 31 ve üstü koltuk
       Tarife dönemi:Aralık 2022,Haziran 2022
       1.dönemi                             2.dönem
          otomobil: 2000                       otomobil: 2500
          kamyon:   3000                       kamyon:   3500
          otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
          motosiklet: 1500                     motosiklet: 1750
        Hatalı girişte hesaplama başarısız uyarsı verip tekrar menü gösterilsin.
    */
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Scanner inp = new Scanner(System.in);
        boolean isFail;
        do {
            isFail = false;
            // menü ve tarife seçme
            System.out.println("zorunlu sigorta primi hesaplama");
            System.out.println("tarife dönemi seçin:");
            System.out.println("1. haziran 2022");
            System.out.println("2. aralık 2022");
            int term = inp.nextInt();
            if (term == 1 || term == 2) {
                String termName = term == 1 ? "haziran 2022" : "aralık 2022";
                Arac arac = new Arac();
                System.out.println("otomobil, kamyon, otobüs, motosiklet");
                System.out.print("araç tipi girin: ");
                arac.type = inp.next();
                arac.prim = arac.countPrim(term);
                int select;
                if (arac.prim>0) {
                    System.out.println("hesaplama tamamlandı");
                    System.out.println("araç tipi: " + arac.type);
                    System.out.println("tarife dönemi: " + termName);
                    System.out.println("sigorta primi: " + arac.prim);
                    System.out.println("yeni işlem için 1, çıkış için 0 girin.");
                    select = inp.nextInt();
                        if (select == 1) {
                            isFail = true;
                        } else {
                            isFail = false;
                        }
                } else {
                    System.out.println("hesaplama başarısız.");
                    System.out.println("yeni işlem için 1, çıkış için 0 girin.");
                    select = inp.nextInt();
                    if (select == 1) {
                        isFail = true;
                    } else {
                        isFail = false;
                    }
                }
            } else {
                System.out.println("hatalı giriş");
                isFail = true;
            }
        } while (isFail);
    }
}
