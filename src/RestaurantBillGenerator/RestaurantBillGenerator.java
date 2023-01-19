package RestaurantBillGenerator;

import java.util.Scanner;

/*
Proje: Restaurant Fiş Üretme Uygulaması(BillGenerator)
       1-Bir restaurantın online sipariş sisteminde hesabı
       yazdıran uygulama tasarlayınız.

       2-Restauranttaki yiyecekler bir listte tutulsun.
         Yiyeceklerin kodu, ismi ve ücreti olsun.

       3-Yiyecek menüsü, sipariş oluşturma/iptal ve hesap
         oluşturma için seçim menüsü gösterilsin.

       4-Yiyecek menü:Listedeki yiyecekler menü şeklinde listelensin
         Sipariş girme:Yiyeceğin kodu ve istenilen adet girilerek sipariş oluşturulsun
                       Her sipariş için kod üretilsin(başlangıç 1000 artarak devam eder)
                       Her bir yiyecek siparişi için tutar hesaplansın

         Sipariş iptal:Sipariş kodu girilerek sipariş silinsin
         Hesap oluşturma: Tutarları ile birlikte tüm siparişleri ve
                          toplam tutarı gösteren bir hesap fişi yazdırılsın.
*/
public class RestaurantBillGenerator {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        OrderService orderService = new OrderService();
        DishService dishService = new DishService();
        dishService.fillDishList();
        getSelectionMenu(dishService, orderService);

    }

    public static void getSelectionMenu(DishService dishService, OrderService orderService) {
        Scanner inp = new Scanner(System.in);
        int select = -1;
        while (select != 0) {
            System.out.println("------------------------------------------");
            System.out.println("*** Lezzet Restoran ***");
            System.out.println("1- Menü");
            System.out.println("2- Sipariş Girin");
            System.out.println("3- Sipariş iptal etme");
            System.out.println("4- Hesap oluşturun");
            System.out.println("0- Çıkış");
            System.out.print("Seçiminiz: ");
            select = inp.nextInt();
            System.out.println("------------------------------------------");
            switch (select) {
                case 1:
                    dishService.showDishMenu();
                    break;
                case 2:
                    orderService.createOrder(dishService);
                    break;
                case 3:
                    orderService.deleteOrder();
                    break;
                case 4:
                    orderService.printBill();
                    break;
                default:
                    System.out.println("hatalı giriş.");
            }
        }
    }
}
