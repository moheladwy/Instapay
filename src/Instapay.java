import enums.AuthenticationStatus;
import logic.*;
import models.*;

import java.util.function.BinaryOperator;

public class Instapay {
    public static User user;

    public Instapay() {
        user = null;
    }

    public static void main(String[] args) {
        Instapay instapay = new Instapay();
        instapay.start();
    }

    public void mainMenu() {
        System.out.println("Welcome to Instapay!");
        System.out.println("Please choose from the following options=>");
        System.out.println("==========================================");
        System.out.println("1- Register.");
        System.out.println("2- Login.");
        System.out.println("3- Exit.");
    }

    public int askUser() {
        System.out.print("Enter your choice: ");
        String choice = System.console().readLine();
        return Integer.parseInt(choice);
    }

    public void start() {
        boolean wannaExit = false;
        while (!wannaExit) {
            mainMenu();
            int choice = askUser();
            AuthenticationStatus status;
            switch (choice) {
                case 1:
                    status = Authentication.register(user);
                    break;
                case 2:
                    status = Authentication.login(user);
                    break;
                case 3:
                    wannaExit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
        System.out.println("Thank you for using Instapay!");
    }
}
