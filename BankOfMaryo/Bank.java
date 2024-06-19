package BankOfMaryo;

import java.util.Random;
import java.util.Scanner;

public class Bank {
    String userName;
    double balance;
    Scanner input = new Scanner(System.in);
    Random random = new Random(); // create random pin for users
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
        System.out.print("Enter 4-digit PIN to continue: ");
        inputPin = input.nextInt();
        if (inputPin == pin) {
            initiateDeposit();
        } else {
            depositAuthentication();
        }
    }

    public void withdrawMoney() {
        System.out.print("Enter 4-digit PIN to continue: ");
        inputPin = input.nextInt();
        if (inputPin == pin) {
            initiateWithdrawal();
        } else {
            withdrawalAuthentication();
        }
    }

    public void checkBalance() {
        System.out.print("Enter 4-digit PIN to continue: ");
        inputPin = input.nextInt();
        if (inputPin == pin) {
            System.out.println("Balance: " + balance);
        } else {
            int tries = 4;
            while (tries > 1) {
                System.out.println("Incorrect Pin. you have " + (tries - 1) + " more tries");
                System.out.print("Enter 4-digit PIN to continue: ");
                inputPin = input.nextInt();
                if (inputPin == pin) {
                    System.out.println("Balance: " + balance);
                    return;
                }
                tries--;
            }
            System.out.println("Incorrect Pin. you have No more tries");
        }
    }

    // Initiate action methods
    private void initiateWithdrawal() {
        System.out.print("Enter amount to withdraw: ");
        int amountToWithdraw = input.nextInt();
        if (amountToWithdraw > balance) {
            System.out.println("Insufficient funds. balance: " + "$" + balance);
        } else {
            balance -= amountToWithdraw;
            System.out.println("Amount withdrawn successfully. New balance: " + "$" + balance);
        }
    }

    private void initiateDeposit() {
        System.out.print("Enter amount to deposit: ");
        balance += input.nextInt();
        System.out.println("Amount deposited successfully. New balance is " + "$" + balance);
    }

    // Authentication Methods
    private void depositAuthentication() {
        int tries = 4;
        while (tries > 1) {
            System.out.println("Incorrect Pin. you have " + (tries - 1) + " more tries");
            System.out.print("Enter 4-digit PIN to continue: ");
            inputPin = input.nextInt();
            if (inputPin == pin) {
                initiateDeposit();
                return;
            }
            tries--;
        }
        System.out.println("Incorrect Pin. you have No more tries");
    }

    private void withdrawalAuthentication() {
        int tries = 4;
        while (tries > 1) {
            System.out.println("Incorrect Pin. you have " + (tries - 1) + " more tries");
            System.out.print("Enter 4-digit PIN to continue: ");
            inputPin = input.nextInt();
            if (inputPin == pin) {
                initiateWithdrawal();
                return;
            }
            tries--;
        }
        System.out.println("Incorrect Pin. you have No more tries");
    }
}