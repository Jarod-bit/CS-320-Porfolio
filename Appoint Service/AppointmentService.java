import java.util.ArrayList;

public class AppointmentService {
    private ArrayList<Appointment> appointments;

    public AppointmentService() {
        appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        for (Appointment existingAppointment : appointments) {
            if (existingAppointment.getAppointmentId().equals(appointment.getAppointmentId())) {
                throw new IllegalArgumentException("Appointment ID already exists");
            }
        }

        appointments.add(appointment);
    }

    public void deleteAppointment(String appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                appointments.remove(appointment);
                return;
            }
        }

        throw new IllegalArgumentException("Appointment ID not found");
    }

    public Appointment getAppointment(String appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                return appointment;
            }
        }

        return null;
    }
}