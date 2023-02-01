package AppointmentApp;
/*
Proje: Randevu oluşturma uygulaması geliştiriniz.

       1-Ana menüde kullanıcıya randevu alma veya görüntülemek için iki seçenek sunulur.
       2-Randevu alma/oluşturma
            -Kullanıcıya mevcut doktorlar ve uygun oldukları tarihler gösterilir.
            -Kullanıcıdan no ile doktor seçmesi istenir.
            -Seçilen doktorun takvimi gösterilir.
            -Randevu alınmak istenen tarihin seçilmesi istenir.
            -en yakın 7 günlük takvim dolmuşsa daha sonra denenmesi istenir.
            -Geçerli bir tarih seçilmişse randevu oluşturulur ve bu tarih doktorun takviminden silinir.
       3-Randevu görüntüleme:
            -Kullanıcıya randevu no sorulur,
             randevu listesinde girilen no ile eşleşen randevu bilgileri yazdırılır.
       4-Doktor:
            -id, isim, branş, takvim
            -takvim: sistemin kullanıldığı günden 1 gün sonra başlamak üzere
                     7 günlük uygun randevu tarihleri

       5-Randevu:
            -id : otomatik üretilsin
            -hasta adı,Doktor,randevu tarihi
       6-Sistemde doktorlar kayıtlı olsun.

 */

import java.util.Scanner;

public class AppointmentApp {

    public static void main(String[] args) {

        star();

    }

    //1. adim pojo class olusturmak
    //2. adim doktor Appointment class olusturmak
    public static void star() {

        Scanner scan = new Scanner(System.in);
        AppointmentService appointmentService = new AppointmentService();
        DoctorService doctorService = new DoctorService();
        System.out.println("Merhaba,Randevu sistemine hosgeldiniz");

        int select;
        do {
            System.out.println("1-Randevu al");
            System.out.println("2-Randevu goruntuleme");
            System.out.println("0-Cikis");
            select = scan.nextInt();
            switch (select) {
                case 1:
                    appointmentService.getAppointment(doctorService);
                case 2:
                    //Goruntule
                case 0:
                    System.out.println("Iyi gunler");
                default:
                    System.out.println("Hatali giris");
            }


        } while (select != 0);


    }
}
