package Hospital_Management_System;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    @SuppressWarnings("static-access")
	public static void main(String[]args){

        Scanner in = new Scanner(System.in);
        boolean bePatient = false;
        boolean beAdmin = false;
        boolean beDoctor = false;
        String tempID;
        String tempName;
        String tempPassword;
        String tempProfession;
        String tempDisease;
        Double tempBalance;
        String enterControl = "";
		Patient tempPatient = null;
		Doctor tempDoctor = null;
        ArrayList<String>notificationBoard = new ArrayList<>();
        ArrayList<String> doctorWishList = new ArrayList<>();
        Admin admin = new Admin("999","ADMIN","admin999");

		ArrayList<String> schedule = new ArrayList<>();
        Doctor.setSchedule(schedule);

        ArrayList<Patient>patients = new ArrayList<>();
        Patient patient1 = new Patient("100","Emre Ercan","emre123","Tuberculosis", 34.2);
        Patient patient2 = new Patient("124","Okan Keskin","okan123","Dyslexia", 76.2);
        Patient patient3 = new Patient("175","Berk Alper","berk123","Acne", 98.8);
        Patient patient4 = new Patient("193","Berker Ugras","berker123","Diarrhea", 13.5);
        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);
        patients.add(patient4);

        ArrayList<Doctor>doctors = new ArrayList<>();
        Doctor doctor1 = new Doctor("301","Ege Sevinc","ege123","Dermatology");
        Doctor doctor2 = new Doctor("343","Nazli Hedik","nazli123","Therapist");
        doctors.add(doctor1);
        doctors.add(doctor2);

        System.out.println("Hospital information system is active and runnning.");
        System.out.println("Please enter the type of login:");
        boolean menuRepeat = true;

        // label koymay� d���n
        while(menuRepeat) {

	        System.out.print("[1] Admin\n[2] Doctor\n[3] Patient\n[0] Terminate program");
	        enterControl = in.next();
	        String enterControl2 = "";
	        boolean var = true;
	        switch (enterControl){
	            case "1":
	            	while(var) {
	            		System.out.println("Enter the admin ID: (Type 0 to return) :");
	            		enterControl2 = in.next();
			            	switch(enterControl2) {

			            		case "0":
			            			var = false;
			            			break;

				            	case "999":
					                beAdmin = true;
					                System.out.println("Login successful!");
					                var = false;
					                menuRepeat = false;
					                break;

					            default:
					            	System.out.println("There is no such admin.");

			            	}

	            	}
	            	break;

	            case "2":
	            	while(var) {
		            	System.out.println("Enter the doctor ID (Type 0 to return) : ");
		            	enterControl2 = in.next();

		            	if(enterControl2.equals("0")) {
		            		var = false;
		            		break;
		            	}
		            	else {

		            	for(int i=0;i<doctors.size();i++){
		                    if(doctors.get(i).getID().equals(enterControl2)){
		                        System.out.println("Login successful!");
		                        beDoctor = true;
		                        menuRepeat = false;
		                        var = false;
		                        tempDoctor=doctors.get(i);
		                        break;
		                    }
		                    else {
		                    	System.out.println("There is no such a doctor.");
		                    	i=doctors.size();


		                    }

		                }
		            	}
	            	}
	            	break;
	            case "3":
	            	while(var) {
		            	System.out.println("Enter the patient ID  (Type 0 to return) :");

		            	if(enterControl2.equals("0")) {
		            		var = false;
		            		break;
		            	}
		            	else {

		            	enterControl2 = in.next();
		            	for(int i=0;i<patients.size();i++){
		                    if(patients.get(i).getID().equals(enterControl2)){
		                        System.out.println("Login successful!");
		                        bePatient = true;
		                        menuRepeat = false;
		                        var = false;
		                        tempPatient=patients.get(i);
		                        break;
		                    }
		                    else {
		                    	System.out.println("There is no such a patient.");
		                    	i=patients.size();


		                    }

		                }
		            	}
	            	}
	            	break;
	            case "0":
	            	System.out.println("Program going dark.");
	            	System.exit(0);
	                break;

	            default:
	            	System.out.println("Invalid value. Please try again.");



	        	}
        }

        while (beAdmin){

            System.out.println("Welcome admin!");
            System.out.println("[1] Display \n[2] Add doctor\n[3] Remove doctor\n[4] Remove all doctors \n[5] Add patient" +
					" \n[6] Remove patient \n[7] Remove all patients \n[8] Show doctorlist \n[9] Show patientlist\n[10] Add notification" +
					"\n[11] Show notifications \n[12] Change doctor profession \n[13] Change patient disease \n[0] Terminate program");

            int adminMenu = 0;

            boolean isException2 = false;
			while (isException2 = true) {
				try {
					adminMenu = in.nextInt();

					if(adminMenu == (int)adminMenu) {
						isException2 = false;
						break;
					}
					else {
						isException2 = true;
					}

				}
				catch (InputMismatchException inputMismatchException) {
					System.out.print("ERROR: ");
					System.out.println(inputMismatchException);
					System.out.println("Please enter only numbers.");

				}
				finally {

				}
				in.nextLine();
			}

            switch (adminMenu){
				case 1:
					System.out.println("Your info is now being displayed");
					admin.display();
					break;

                case 2:
                	System.out.println("Please fill information for the new doctor");
                	System.out.println("ID");
                	tempID = in.next();
                	System.out.println("Name");
                	tempName = in.next();
                	System.out.println("Password");
                	tempPassword = in.next();
                	System.out.println("Profession");
                	tempProfession=in.next();
                	Doctor tempDoctor1 = new Doctor(tempID,tempName,tempPassword,tempProfession);
                    admin.addDoctor(doctors, tempDoctor1);
                    break;

                case 3:
                	System.out.println("Please type the ID of the doctor that you want to remove");
                	tempID=in.next();
                	for(int i=0;i<doctors.size();i++) {
                		if(doctors.get(i).getID().equals(tempID)) {
                			doctors.remove(i);
                		}
                		else {
                			System.out.println("There is no such doctor. Returning to menu.");
                		}
                	}

                    break;
                case 4:
                    System.out.println("Clearing all doctors from the system...");
                    admin.removeAllDoctors(doctors);
                    break;
                case 5:
                	System.out.println("Please fill the information for the new patient");
					System.out.println("ID");
					tempID = in.next();
					System.out.println("Name");
					tempName = in.next();
					System.out.println("Password");
					tempPassword = in.next();
					System.out.println("Disease");
					tempDisease=in.next();
					System.out.println("Balance");
					tempBalance=in.nextDouble();
					Patient tempPatient1 = new Patient(tempID,tempName,tempPassword,tempDisease,tempBalance);
					admin.addPatient(tempPatient1,patients);

                    break;
                case 6:
                	System.out.println("Please type the ID of the patient that you want to remove");
                	tempID=in.next();
                	for(int i=0;i<patients.size();i++){
                		if(patients.get(i).getID().equals(tempID)){
                			patients.remove(i);
						}
						else {
							System.out.println("There is no such patient");
						}
					}
                	break;
                case 7:
                    System.out.println("Clearing all patients from the system");
                    admin.removeAllPatients(patients);
                    break;
				case 8:
					System.out.println("The doctorlist is now being shown");
					admin.showDoctorList(doctors);
					break;

				case 9:
					System.out.println("The patientlist is now being shown");
					admin.showPatientList(patients);
					break;
				case 10:
					System.out.println("You will now add a notification to the board");
					admin.addToNotificationBoard(notificationBoard);
					break;
				case 11:
					System.out.println("The notification board is now shown");
					admin.showNotificationBoard(notificationBoard);
					break;
				case 12:
					System.out.println("Please type the id of the doctor that you want to change the profession of");
					tempID=in.next();
					System.out.println("Please type the new profession for the doctor");
					tempProfession=in.next();
					Admin.changeProfessionForDoctor(tempID,tempProfession,doctors);
				break;
				case 13:
					System.out.println("Please type the id of the patient that you want to change the disease of");
					tempID=in.next();
					System.out.println("Please type the new disease for the patient");
					tempDisease=in.next();
					Admin.changeDiseaseForPatient(tempID,tempDisease,patients);
					break;


                case 0:
                	beAdmin=false;
                	System.out.println("Program going dark.");
                	break;
                default:
                	System.out.println("Invalid value. Please enter only numbers.");
                    break;
            }
        }

        while (bePatient){

            System.out.println("Welcome patient!");
            System.out.println("[1] Display \n[2] Show notification \n[3] Report wish \n[0] Terminate program");

            int patientMenu = 0;

            boolean isException2 = false;
			while (isException2 = true) {
				try {
					patientMenu = in.nextInt();

					if(patientMenu == (int)patientMenu) {
						isException2 = false;
						break;
					}
					else {
						isException2 = true;
					}

				}
				catch (InputMismatchException inputMismatchException) {
					System.out.print("ERROR: ");
					System.out.println(inputMismatchException);
					System.out.println("Please enter only numbers.");

				}
				finally {

				}
				in.nextLine();
			}

            switch (patientMenu){

                case 1:
					System.out.println("Your info is now being displayed");
                	tempPatient.display();
                case 2:
                   System.out.println("notification board is now shown");
                   tempPatient.showNotificationBoard(notificationBoard);
                   break;
				case 3:
					System.out.println("Please type the wish you want to be added to the doctors wish box");
					String wish = in.next();
					tempPatient.reportWish(wish,doctorWishList);
					break;

                case 0:
                	System.out.println("Please type the amount of your balance");
                	tempBalance=in.nextDouble();
                	tempPatient.payFee(tempBalance);
                	bePatient = false;
                	System.out.println("Program going dark.");
                	break;

                default:

                	System.out.println("Invalid value. Please enter only numbers.");

            }
        }
        while (beDoctor){

            System.out.println("Welcome doc!");
            System.out.println("[1] Display \n[2] Show schedule \n[3] Change disease for patient \n[4] Show patientlist " +
					"\n[5] Show wishbox \n[6] Add notification \n[7] Show notification \n[0] Terminate program");

            int docMenu = 0;

            boolean isException2 = false;
			while (isException2 = true) {
				try {
					docMenu = in.nextInt();

					if(docMenu == (int)docMenu) {
						isException2 = false;
						break;
					}
					else {
						isException2 = true;
					}

				}
				catch (InputMismatchException inputMismatchException) {
					System.out.print("ERROR: ");
					System.out.println(inputMismatchException);
					System.out.println("Please enter only numbers.");

				}
				finally {

				}
				in.nextLine();
			}

            switch (docMenu){

                case 1:
                    System.out.println("Your info is now being displayed");
                    tempDoctor.display();
                    break;
                case 2:
                	System.out.println("The doctors work hours are the following:");
                   tempDoctor.showSchedule(doctors,schedule);
                    break;
                case 3:
					System.out.println("Please type the id of the patient that you want to change the disease of");
					tempID=in.next();
					System.out.println("Please type the new disease for the patient");
					tempDisease=in.next();
					tempDoctor.changeDiseaseForPatient(tempID,tempDisease,patients);
					break;

				case 4:
					System.out.println("The patientlist is now being shown");
					tempDoctor.showPatientList(patients);
					break;
				case 5:
					System.out.println("The wish box is now being shown");
					tempDoctor.showWishBox(doctorWishList);
					break;
				case 6:
					System.out.println("You will now add a notification to the board");
					tempDoctor.addToNotificationBoard(notificationBoard);
					break;
				case 7:
					System.out.println("The notification board is now shown");
					tempDoctor.showNotificationBoard(notificationBoard);
					break;
                case 0:
                	beDoctor = false;
                	System.out.println("Program going dark.");
                	break;

                default:
                	System.out.println("Invalid value. Please enter only numbers.");

            }
        }
    }
}
