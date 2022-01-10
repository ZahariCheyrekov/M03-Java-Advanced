package M03_JavaAdvanced.L06_DefiningClasses.Lab.T03BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, BankAccount> accountMap = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String command = data[0];

            String output = "";
            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    accountMap.put(bankAccount.getId(), bankAccount);
                    output = (String.format("Account ID%d created", bankAccount.getId()));
                    break;

                case "Deposit":
                    int id = Integer.parseInt(data[1]);
                    int amount = Integer.parseInt(data[2]);
                    BankAccount bankAccount1 = accountMap.get(id);
                    output = executeIfNotNull(bankAccount1, b -> {
                        b.deposit(amount);
                        return String.format("Deposited %d to ID%d", amount, id);
                    });
                    break;

                case "SetInterest":
                    double interestRate = Double.parseDouble(data[1]);
                    BankAccount.setInterestRate(interestRate);
                    break;

                case "GetInterest":
                    int ID = Integer.parseInt(data[1]);
                    int years = Integer.parseInt(data[2]);
                    BankAccount bankAccount2 = accountMap.get(ID);
                    output = executeIfNotNull(bankAccount2, b -> {
                        double interest = b.getInterestRate(years);
                        return String.format("%.2f", interest);
                    });
                    break;
            }
            System.out.println(output);
            input = scanner.nextLine();
        }
    }

    public static String executeIfNotNull(BankAccount bankAccount, Function<BankAccount, String> function) {
        if (bankAccount == null) {
            return "Account does not exist";
        }
        return function.apply(bankAccount);
    }
}