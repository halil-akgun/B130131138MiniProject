package AppointmentApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentService {

    Scanner inp = new Scanner(System.in);

    List<Appointment> appointments = new ArrayList<>();

    public void getAppointment(DoctorService doctorService) {
        doctorService.printDoctors();
        System.out.println("randevu almak istediginiz doktoru seciniz (no) :");
        int selectDoctor = inp.nextInt();

        if (doctorService.getDoctorById(selectDoctor) != null) {
            Doctor doctor = doctorService.getDoctorById(selectDoctor);
            if (!doctor.getDates().isEmpty()) {
                inp.nextLine();
                System.out.print("isminiz: ");
                String name = inp.nextLine();
                System.out.println("sayin " + name + ", randevu alabileceginiz tarihler:");
                for (int i = 0; i < doctor.getDates().size(); i++) {
                    System.out.println(i + 1 + " - " + doctor.getDates().get(i));
                }
                System.out.println("istediginiz tarihin numarasini girin:");
                int select = inp.nextInt();
                inp.nextLine();
                if (select > 0 && select <= doctor.getDates().size()) {
                    Appointment appointment = new Appointment(name, doctor, doctor.getDates().get(select - 1));
                    this.appointments.add(appointment);
                    System.out.println("sayin " + name + ", randevu tarihiniz: " + doctor.getDates().get(select - 1));
                    System.out.println("randevu no: " + appointment.getId() + " ile randevu bilgilerinizi goruntuleyebilirsiniz.");
                    doctor.getDates().remove(select - 1);
                } else System.out.println("hatali giris");
            } else System.out.println(doctor.getName() + " isimli dpktorun bu hafta tum randevulari dolu.");
        } else System.out.println("hatali giris");
    }

    public void printAppointment() {
        System.out.print("randevu no girin:");
        int appId = inp.nextInt();
        boolean isExist = true;
        for (Appointment app : appointments) {
            if (app.getId() == appId) {
                isExist = true;
                System.out.println("-----------------------------");
                System.out.println(appId + " nolu randevu bilgileri");
                System.out.println("hasta adi      : " + app.getName());
                System.out.println("brans          : " + app.getDoctor().getDepartment());
                System.out.println("doktor         : " + app.getDoctor().getName());
                System.out.println("randevu tarihi : " + app.getDate());
                System.out.println("-----------------------------");
            }
        }
    }
}
