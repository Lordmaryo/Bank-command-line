package BankOfMaryo;

import java.util.Random;
import java.util.Scanner;

public class Bank {
    String userName;
    double balance;


    Scanner input = new Scanner(System.in);

    Random random = new Random();
    int pin = 1000 + random.nextInt(9000);
    int inputPin;

    public void createAccount() {
        System.out.print("Enter account holder's name: ");
        String userInput = input.nextLine();
        boolean isUserInputBlank = userInput == null || userInput.trim().isEmpty();

        // TODO: make sure correct User name is stored after second try

        if (isUserInputBlank) {
            System.out.println("User name cannot be blank.");
            System.out.print("Enter account holder's name: ");
            userInput = input.nextLine();
        } else {
            this.userName = userInput;
            System.out.println("Welcome " + this.userName + ". Your 4-digit PIN is: " + pin);
        }
    }

    public void depositMoney() {
        System.out.print("Enter pin to deposit: ");
        inputPin = input.nextInt();

        if (inputPin == pin) {
            initiateDeposit();
        } else {
            checkAuthentication();
        }
    }

    private void initiateDeposit() {
        System.out.print("Enter amount to deposit: ");
        balance += input.nextInt();
        System.out.println("Amount deposited successfully. New balance is " + "$" + balance);
    }

    private void checkAuthentication() {
        int tries = 3;
        while (tries > 1) {
            System.out.println("Incorrect Pin. you have " + (tries - 1) + " more tries");
            System.out.print("Enter pin to deposit: ");
            inputPin = input.nextInt();
            if (inputPin == pin) {
                initiateDeposit();
                return;
            }
            tries--;
        }
        System.out.println("Incorrect Pin. you have No more tries");
    }
}