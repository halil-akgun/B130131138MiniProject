/*
Proje: Sayısal Loto Uygulaması
       bilet için rastgele n tane sayı üretilsin.
       loto sonucu rastgele n tane sayı ile üretilsin.
       sayısal lotoda tekrarlı sayılar olmamalı.

       n(hane sayısı), sayılar için min ve max değerler
       kullanıcıdan alınsın.

       sonuç ve bilet karşılaştırılsın, kaç eşleşme olduğu
       kullanıcıya bildirilsin.

*/

import java.util.Random;
import java.util.Scanner;

public class SayisalLoto {
    public static void main(String[] args) {

        startLoto();

    }

    public static void startLoto() {
        Scanner inp = new Scanner(System.in);
        System.out.println("sayısal loto için hane sayısı girin:");
        int slots = inp.nextInt();
        System.out.println("sayılar için min değer girin:");
        int min = inp.nextInt();
        System.out.println("sayılar için max değer girin:");
        int max = inp.nextInt();

        int lotoArr[] = new int[slots];
        int ticketArr[] = new int[slots];
        boolean isRepeated;

        Random random = new Random();
        int randomNum1 = 0;
        int randomNum2 = 0;

        for (int i = 0; i < slots; i++) {

            // lotoArr doldur
            do {
                isRepeated = false;
                randomNum1 = random.nextInt(max + 1 - min) + min;
                // 10 yazarsak: 0'dan 10'a kadar sayılar..
                // max:10 min:5 ise (max+1-min)+min --> (10+1-5)+5 --> 0-5 arası sayı üretip 5 ekler, yani 5-10 arası
                // random.nextInt(6)+5; --> [0,5]+5 --> [5,10]
                for (int j = 0; j < i; j++) {
                    if (lotoArr[j] == randomNum1) {
                        isRepeated = true;
                        break;
                    }
                }
            } while (isRepeated);
            lotoArr[i] = randomNum1;

            // ticketArr doldur
            do {
                isRepeated = false;
                randomNum2 = random.nextInt(max + 1 - min) + min; // 10 yazarsak: 0'dan 10'a kadar sayılar..
                for (int j = 0; j < i; j++) {
                    if (ticketArr[j] == randomNum1) {
                        isRepeated = true;
                        break;
                    }
                }
            } while (isRepeated);
            ticketArr[i] = randomNum2;
        }
        System.out.println("benim biletim: ");
        for (int i = 0; i < slots; i++) {
            System.out.print(ticketArr[i] + " ");
        }
        System.out.println();
        System.out.println("loto sonucu: ");
        for (int i = 0; i < slots; i++) {
            System.out.print(lotoArr[i] + " ");
        }
    }
}
