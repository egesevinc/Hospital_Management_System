package Hospital_Management_System;



import java.util.ArrayList;
import java.util.Scanner;
public class Admin extends Person{

    Admin(String ID, String name, String password){

        super(ID, name, password);

    }

    public Admin() {
        this.setName("Null");
        this.setID("Null");
        this.setPassword("Null");
    }


    public void addDoctor(ArrayList<Doctor>doctors, Doctor doctorToAdd){
        doctors.add(doctorToAdd);
    }

    public void removeAllDoctors(ArrayList<Doctor> doctors) {
    	doctors.clear();
    }
    
    public void addPatient(Patient p1,ArrayList<Patient> patientList) {
    	patientList.add(p1);
    }

    public void removeAllPatients(ArrayList<Patient> patientList) {
    	patientList.clear();
    }
    
    public void showDoctorList(ArrayList<Doctor> doctorList) {
    	System.out.println("### DOCTOR LIST ###");
    	for(Doctor doctor : doctorList) {
    		doctor.display();
    	}
    }
    
    public void showPatientList(ArrayList<Patient>patientList) {
    	System.out.println("### PATIENT LIST ###");
    	for(Patient patient : patientList) {
    		patient.display();
    	}
    }
    

    public void addToNotificationBoard(ArrayList<String> notificationBoard){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the notification that you want to add to the board");
        String message = in.next();
        notificationBoard.add(message);
      
    }
    
    @Override // runtime polymorphism is used here
    public void showNotificationBoard(ArrayList<String> notificationBoard) {
    	System.out.println("### NOTIFICATION BOARD ###");
    	for(int i=0;i<notificationBoard.size();i++) {
    		System.out.println(notificationBoard.get(i));
    	}
    }
    
    public static void changeProfessionForDoctor(String tempID, String tempProfession,ArrayList<Doctor>doctors){
        for(Doctor doctor : doctors){
            if(doctor.getID().equals(tempID)){
                doctor.setProfession(tempProfession);
                System.out.println("The profession is now changed");
                break;
            }
            else System.out.println("No such patient exists");
            break;
        }

    }
    
    @SuppressWarnings("Duplicates")
    public static void changeDiseaseForPatient(String tempID, String tempDisease,ArrayList<Patient> patients) {

        for(Patient patient : patients){
            if(patient.getID().equals(tempID)){
                patient.setDisease(tempDisease);
                System.out.println("The diseae is now changed");
                break;
            }
            else System.out.println("No such patient exists");
            break;
        }
    }

    @Override // runtime polymorphism is used here
    public void display() {
        System.out.println("This user is an admin");
        System.out.println("ID is "+getID());
        System.out.println("Name is "+getName());
    }
}
