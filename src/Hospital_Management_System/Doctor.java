package Hospital_Management_System;


import java.util.ArrayList;
import java.util.Scanner;

public class Doctor extends Person {
    String profession;
    ArrayList <String> schedule = new ArrayList<>(8);

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Doctor(String ID, String name, String password, String profession) {
        super(ID, name, password);
        this.profession = profession;
    }

    public Doctor() {

        this.setProfession("Null");
        this.setID("Null");
        this.setName("Null");
        this.setPassword("Null");

    }

    public static void setSchedule(ArrayList<String> schedule) {
        schedule.add(0,"9:00");
        schedule.add(1,"10:00");
        schedule.add(2,"11:00");
        schedule.add(3,"12:00");
        schedule.add(4,"13:00");
        schedule.add(5,"14:00");
        schedule.add(6,"15:00");
        schedule.add(7,"16:00");
    }

    public void showSchedule(ArrayList<Doctor>doctors,ArrayList<String> schedule) {

        for (int i =0;i<schedule.size();i++) {
            System.out.println(schedule.get(i));
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
    
    public void showWishBox(ArrayList<String>doctorWishBox) {
    	for(int i=0;i<doctorWishBox.size();i++) {
    		System.out.println(doctorWishBox.get(i));
    	}
    }
    
    public void showPatientList(ArrayList<Patient>patientList) {
        System.out.println("### PATIENT LIST ###");
        for(Patient patient : patientList) {
            patient.display();
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
        System.out.println("This user is a doctor");
        System.out.println("ID is "+getID());
        System.out.println("Name is "+getName());
        System.out.println("Role is "+getProfession());

    }
}
