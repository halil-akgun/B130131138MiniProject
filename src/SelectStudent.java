import java.util.Scanner;

public class SelectStudent {
    public static void main(String[] args) {

        /*
        Proje: Spor kursu için seçilecek öğrencileri belirleyen
               bir uygulama yazınız.

               kurs gereklilikleri:
                    erkekler: boy: 1.60 ve üstü
                              kilo:70-90 kg
                    kızlar: boy: 1.50 ve üstü
                            kilo:50-70 kg

               kullanıcıdan öğrenci sayısı ve herbir öğrenci
               için isim , cinsiyet, kilo ve boy bilgilerini girmesini
               isteyiniz.
        */
        Scanner scan = new Scanner(System.in);
        System.out.println("Merhaba. lütfen formu doldurunuz.");
        System.out.print("öğrenci sayısını girin: ");
        int numberStudent = scan.nextInt();
        String students[] = new String[numberStudent];
        String gender[] = new String[numberStudent];
        double height[] = new double[numberStudent];
        double weight[] = new double[numberStudent];

        boolean isSuccess = true;
        do {
            isSuccess = true;
            for (int i = 0; i < numberStudent; i++) {
                System.out.print("isim: ");
                students[i] = scan.next();

                System.out.print("cinsiyet: ");
                String gen = scan.next().trim().toUpperCase().substring(0, 1);
                if (gen.equals("K") || gen.equals("E")) {
                    gender[i] = gen;
                } else {
                    System.out.println("hatalı giriş!");
                    isSuccess = false;
                    break;
                }

                System.out.print("boy: ");
                height[i] = scan.nextDouble();

                System.out.print("kilo: ");
                weight[i] = scan.nextDouble();
            }
        } while (!isSuccess);

        int counter = 0;
        System.out.println("*** Kursa Seçilen Öğrenciler ***");
        for (int i = 0; i < numberStudent; i++) {
            if (gender[i].equals("K") && height[i] >= 1.50 && weight[i] >= 50 && weight[i] <= 70) {
                System.out.println("isim: " + students[i] + " cinsiyet: " + gender[i]
                        + " boy: " + height[i] + " kilo: " + weight[i]);
                counter++;
            } else if (gender[i].equals("E") && height[i] >= 1.60 && weight[i] >= 70 && weight[i] <= 90) {
                System.out.println("isim: " + students[i] + " cinsiyet: " + gender[i]
                        + " boy: " + height[i] + " kilo: " + weight[i]);
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("kurs gereksinimlerini karşılayan öğrenci bulunamadı.");
        }


    }
}
