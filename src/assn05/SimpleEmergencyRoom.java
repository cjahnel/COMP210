package assn05;

import java.util.ArrayList;
import java.util.List;

public class SimpleEmergencyRoom {
    private List<Patient> patients;

    public SimpleEmergencyRoom() {
        patients = new ArrayList<>();
    }

    public Patient dequeue() {
        Patient highestPriorityPatient = patients.get(0);
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            Integer highestPriority = (Integer) highestPriorityPatient.getPriority();
            if (patient.getPriority().compareTo(highestPriority) > 0) {
                highestPriorityPatient = patient;
            }
        }
        patients.remove(highestPriorityPatient);
        return highestPriorityPatient;
    }

    public <V, P> void addPatient(V value, P priority) {
        Patient patient = new Patient(value, (Integer) priority);
        patients.add(patient);
    }

    public <V> void addPatient(V value) {
        Patient patient = new Patient(value);
        patients.add(patient);
    }

    public List getPatients() {
        return patients;
    }

    public int size() {
        return patients.size();
    }

}
