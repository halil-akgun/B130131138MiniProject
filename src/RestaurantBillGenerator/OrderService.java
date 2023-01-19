package RestaurantBillGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {

    Scanner inp = new Scanner(System.in);

    List<Order> orderList = new ArrayList<>();
    int totalPrice;

    public void createOrder(DishService dishService) {
        int dishCode = -1;
        while (dishCode != 0) {
            System.out.print("ürün kodunu girin (çıkış için 0): ");
            dishCode = inp.nextInt();
            Dish dish = dishService.findDish(dishCode);
            if (dish.getCode() > 0) {
                System.out.print("Adet girin: ");
                int num = inp.nextInt();
                Order order = new Order(dish, num);
                order.setPrice();
                order.setOrderCode(1000 + this.orderList.size());
                this.orderList.add(order);
            }
            for (Order order : this.orderList) {
                System.out.printf("Sipariş kodu: %-5s    Lezzet Kodu:%-4s adı:%-20s adet:%-3s\n",
                        order.orderCode, order.dish.getCode(), order.dish.getName(), order.numOfDish);
            }
        }
    }

    public void deleteOrder() {
        boolean isValid = true;
        if (this.orderList.isEmpty()) {
            System.out.println("siparişiniz bulunmamaktadır.");
        } else {
            System.out.print("iptal etmek istediğiniz siparişin kodu: ");
            int code = inp.nextInt();
            for (Order order : this.orderList) {
                if (order.orderCode == code) {
                    this.orderList.remove(order);
                    System.out.println("siparişiniz iptal edildi: " + order.dish.toString());
                    isValid = true;
                    break;
                } else {
                    isValid = false;
                }
            }
            if (!isValid) System.out.println("Sipariş kodu geçersiz");
        }
    }

    public void printBill() {
        System.out.println("          Fişiniz           ");
        for (Order order : this.orderList) {
            //System.out.printf("Lezzet Kodu:%-5s   Adı:%-20s   Adet:%-5s   Sipariş Tutarı:%-5s \n",
              //      order.dish.getCode(), order.dish.getName(), order.numOfDish, order.orderPrice);
            System.out.printf("Lezzet kodu:%-5s adı:%-20s adet:%-5s sipariş tutarı:%-5s Lira\n",
                    order.dish.getCode(),order.dish.getName(),order.numOfDish,order.orderPrice);
                     totalPrice += order.orderPrice;
            System.out.println("Toplam Tutar: " + totalPrice);
            System.out.println("Afiyet olsun...");
            this.orderList = new ArrayList<>();
        }
    }

}
