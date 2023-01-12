package biletFiyatHesaplama;

import java.util.ArrayList;
import java.util.List;

public class Bus {

    public String numberPlate;

    public List<String> seats = new ArrayList<>();

    public Bus(String plaka, List<String> koltuk) {
        this.numberPlate = plaka;
        this.seats = koltuk;
    }
}
