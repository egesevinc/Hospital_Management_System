package Hospital_Management_System;


import java.util.ArrayList;

public class Patient extends Person {

    private String disease;
    private double balance;

    public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Patient() {
        this.disease="Unkown";
        this.setID("Null");
        this.setName("Null");
        this.setPassword("Null");
        this.setBalance(0.0);
    }

    public Patient(String ID, String name, String password, String disease,double balance) {
        super(ID, name, password);
        this.disease = disease;
        this.balance=balance;
    }
    
    public double payFee(double balance) {
    	if(balance>0) {
    		balance -=(balance*0.01+(10));
    		System.out.println("Your remaining balance is :"+balance);
    		return balance;
    	}
    	System.out.println("Insufficent funds.");
    	return 0;
    	    	
    }

    public  void reportWish(String message,ArrayList<String> doctorWishBox) {
    	doctorWishBox.add(message);
       
    }
    
    @Override // runtime polymorphism is used here
        public void showNotificationBoard(ArrayList<String> notificationBoard) {
        	System.out.println("### NOTIFICATION BOARD ###");
        	for(int i=0;i<notificationBoard.size();i++) {
        		System.out.println(notificationBoard.get(i));
        	}
        }

    @Override // runtime polymorphism is used here
    public void display() {
        System.out.println("This user is a patient");
        System.out.println("ID is "+getID());
        System.out.println("Name is "+getName());
        System.out.println("Disease is "+getDisease());
        System.out.println("The balance "+getBalance());

    }
}
