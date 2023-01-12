package biletFiyatHesaplama;

public class Bilet {

    public int distance;

    public int typeNo;

    public double price;

    public int seatNo;

    public void printBilet(Bus bus) {
        System.out.println("toplam tutar: " + price);
        System.out.println("------ bilet detay -------");
        System.out.println("plaka: " + bus.numberPlate);
        System.out.println("mesafe: " + distance);
        System.out.println("yolculuk tipi: " + (typeNo == 1 ? "tek yön" : "gidiş-dönüş"));
        System.out.println("koltuk no: " + seatNo);
        System.out.println("keyifli yolculuklar...");
    }

}
