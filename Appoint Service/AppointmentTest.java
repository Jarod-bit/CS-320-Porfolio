import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import org.junit.jupiter.api.Test;

public class AppointmentTest {

    private Date getFutureDate() {
        return new Date(System.currentTimeMillis() + 86400000);
    }

    private Date getPastDate() {
        return new Date(System.currentTimeMillis() - 86400000);
    }

    @Test
    public void testAppointmentCreatedSuccessfully() {
        Appointment appointment = new Appointment("1234567890", getFutureDate(), "Doctor appointment");

        assertEquals("1234567890", appointment.getAppointmentId());
        assertEquals("Doctor appointment", appointment.getDescription());
        assertNotNull(appointment.getAppointmentDate());
    }

    @Test
    public void testAppointmentIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", getFutureDate(), "Doctor appointment");
        });
    }

    @Test
    public void testAppointmentIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, getFutureDate(), "Doctor appointment");
        });
    }

    @Test
    public void testAppointmentDateNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", null, "Doctor appointment");
        });
    }

    @Test
    public void testAppointmentDateInPast() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", getPastDate(), "Doctor appointment");
        });
    }

    @Test
    public void testDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", getFutureDate(),
                    "This description is longer than fifty characters and invalid");
        });
    }

    @Test
    public void testDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", getFutureDate(), null);
        });
    }

    @Test
    public void testSetAppointmentDate() {
        Appointment appointment = new Appointment("12345", getFutureDate(), "Doctor appointment");
        Date newDate = new Date(System.currentTimeMillis() + 172800000);

        appointment.setAppointmentDate(newDate);

        assertEquals(newDate, appointment.getAppointmentDate());
    }

    @Test
    public void testSetDescription() {
        Appointment appointment = new Appointment("12345", getFutureDate(), "Doctor appointment");

        appointment.setDescription("Dentist appointment");

        assertEquals("Dentist appointment", appointment.getDescription());
    }
}