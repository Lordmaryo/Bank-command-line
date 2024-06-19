package BankOfMaryo;

import java.util.Random;
import java.util.Scanner;

public class Bank {
    String userName;
    double balance;


    Scanner input = new Scanner(System.in);

    Random random = new Random();
    int pin = 1000 + random.nextInt(9000);
    int usersPin;

    public void createAccount() {
        System.out.print("Enter account holder's name: ");
        this.userName = input.nextLine();

        System.out.println("Welcome " + this.userName + ". Your 4-digit PIN is: " + pin);
    }

    public void depositMoney() {
        System.out.print("Enter pin to deposit: ");
        usersPin = input.nextInt();

        if (usersPin == pin) {
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
            usersPin = input.nextInt();
            if (usersPin == pin) {
                initiateDeposit();
                return;
            }
            tries--;
        }
        System.out.println("Incorrect Pin. you have No more tries");
    }
}