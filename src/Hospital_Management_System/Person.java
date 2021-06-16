package Hospital_Management_System;


import java.util.ArrayList;

public abstract class Person implements Screen {
    private String ID;
    private String password;
    private String name;
    protected ArrayList<String> inbox = new ArrayList<>();

    Person(){
        this.ID = "000";
        this.name = "Unknown";
        this.password = "123";
    }
    
    Person(String ID, String name, String password){

        this.ID = ID;
        this.name = name;
        this.password = password;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void display();
    
    public abstract void showNotificationBoard(ArrayList<String> notificationBoard);
}
