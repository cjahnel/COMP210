package assn05;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        testP1();
        testP2();
        testP3();
        testP4();
    }

    // test Part 1
    public static void testP1(){
        /*
        Part 1 - Write some tests to convince yourself that your code for Part 1 is working
         */
        SimpleEmergencyRoom simpleER = new SimpleEmergencyRoom();
        String[] patients = {
                "Christian",
                "Mia",
                "Annie",
                "Kaitlin",
                "Matida",
                "Stella",
                "Marcella",
                "Evan"
        };
        for (String patient : patients) {
            simpleER.addPatient(patient);
        }
        for (int i = 0; i < patients.length; i++) {
            Patient dequeuedPatient = simpleER.dequeue();
            System.out.println(dequeuedPatient.getValue());
        }
    }

    // test Part 2
    public static void testP2(){
        /*
        Part 2 - Write some tests to convince yourself that your code for Part 2 is working
         */
        MaxBinHeapER<String, Integer> maxBinHeapER = new MaxBinHeapER<>();
        String[] patients = {
            "Christian",
            "Mia",
            "Annie",
            "Kaitlin",
            "Matida",
            "Stella",
            "Marcella",
            "Evan"
        };
        for (String patient : patients) {
            Random random = new Random();
            Integer priority = random.nextInt(1000000);
            System.out.println(patient + ": " + priority);
            maxBinHeapER.enqueue(patient, priority);
        }
        for (int i = 0; i < patients.length; i++) {
            Object dequeuedPatientValue = maxBinHeapER.dequeue();
            System.out.println(dequeuedPatientValue);
        }
    }

    /*
    Part 3
     */
    public static void testP3(){
        MaxBinHeapER transfer = new MaxBinHeapER(makePatients());
        Prioritized[] arr = transfer.getAsArray();
        for(int i = 0; i < transfer.size(); i++) {
            System.out.println("Value: " + arr[i].getValue()
                    + ", Priority: " + arr[i].getPriority());
        }
    }

    /*
    Part 4
     */
    public static void testP4() {
               /*
        Part 4 - Write some tests to convince yourself that your code for Part 4 is working
         */
        double[] results = compareRuntimes();
        System.out.println(results[0]);
        System.out.println(results[1]);
        System.out.println(results[2]);
        System.out.println(results[3]);
    }

    public static void fillER(MaxBinHeapER complexER) {
        for(int i = 0; i < 100000; i++) {
            complexER.enqueue(i);
        }
    }
    public static void fillER(SimpleEmergencyRoom simpleER) {
        for(int i = 0; i < 100000; i++) {
            simpleER.addPatient(i);
        }
    }

    public static Patient[] makePatients() {
        Patient[] patients = new Patient[10];
        for(int i = 0; i < 10; i++) {
            patients[i] = new Patient(i);
        }
        return patients;
    }

    public static double[] compareRuntimes() {
        // Array which you will populate as part of Part 4
        double[] results = new double[4];

        SimpleEmergencyRoom simplePQ = new SimpleEmergencyRoom();
        fillER(simplePQ);

        // Code for (Task 4.1) Here
        long initialTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            simplePQ.dequeue();
        }
        long finalTime = System.nanoTime();
        results[0] = finalTime - initialTime;
        results[1] = (finalTime - initialTime)/100000.0;

        MaxBinHeapER binHeap = new MaxBinHeapER();
        fillER(binHeap);

        // Code for (Task 4.2) Here
        initialTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            binHeap.dequeue();
        }
        finalTime = System.nanoTime();
        results[2] = finalTime - initialTime;
        results[3] = (finalTime - initialTime)/100000.0;

        return results;
    }

}
