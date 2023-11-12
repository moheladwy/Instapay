import enums.AuthenticationStatus;
import logic.*;
import models.*;

public class Instapay {
    public static void main(String[] args) {
        Instapay instapay = new Instapay();
    }

    public void mainMenu() {
        System.out.println("Welcome to Instapay!");
        System.out.println("Please choose from the following options=>");
        System.out.println("==========================================");
        System.out.println("1- Register.");
        System.out.println("2- Login.");
        System.out.println("3- Exit.");
    }
}
