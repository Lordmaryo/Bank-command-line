package BankOfMaryo;

import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Bank bankList = new Bank();
        System.out.println("Welcome to the bank of LordMaryo");
        Scanner input = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Check balance");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    bankList.createAccount();
                    break;
                case 2:
                    if (bankList.userName == null) {
                        System.out.println("To Deposit, you need to have an account, select option 1.");
                    } else bankList.depositMoney();
                    break;
                case 3:
                    System.out.println("3 selected");
                    break;
                case 4:
                    System.out.println("4 selected");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}