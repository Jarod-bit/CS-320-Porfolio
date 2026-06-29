import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {

    private Date getFutureDate() {
        return new Date(System.currentTimeMillis() + 86400000);
    }

    @Test
    public void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("12345", getFutureDate(), "Doctor appointment");

        service.addAppointment(appointment);

        assertEquals(appointment, service.getAppointment("12345"));
    }

    @Test
    public void testAddDuplicateAppointmentId() {
        AppointmentService service = new AppointmentService();

        Appointment appointmentOne = new Appointment("12345", getFutureDate(), "Doctor appointment");
        Appointment appointmentTwo = new Appointment("12345", getFutureDate(), "Dentist appointment");

        service.addAppointment(appointmentOne);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointmentTwo);
        });
    }

    @Test
    public void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("12345", getFutureDate(), "Doctor appointment");

        service.addAppointment(appointment);
        service.deleteAppointment("12345");

        assertNull(service.getAppointment("12345"));
    }

    @Test
    public void testDeleteAppointmentNotFound() {
        AppointmentService service = new AppointmentService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("99999");
        });
    }
}