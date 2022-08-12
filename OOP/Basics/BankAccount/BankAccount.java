import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    public static int numberOfAccounts = 0;
    public static double totalMoneyStored = 0;
    private String accountNumber;

    public BankAccount() {
        numberOfAccounts++; 
        this.checkingBalance = 0.0;
        this.savingsBalance = 0.0;
        this.accountNumber = createAcctNum();
    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void deposit(String account, double amount) {
        if (account.equals("checking")) {
            this.checkingBalance += amount;
        } else if (account.equals("savings")) {
            this.savingsBalance += amount;
        }
        totalMoneyStored += amount;
    }

    public void withdraw(String account, double amount) {
        if (account.equals("checking") && amount <= checkingBalance) {
            this.checkingBalance -= amount;
            totalMoneyStored -= amount;
        } else if (account.equals("savings") && amount <= savingsBalance) {
            this.savingsBalance -= amount;
            totalMoneyStored -= amount;
        } else {
            System.out.println("Please enter a valid account with sufficent funds.");
        }
    }

    public void getBalances() {
        System.out.printf("Checking Balance: $%.2f\nSavings Balance: $%.2f\nTotal Holdings: $%.2f\nTotal Accounts: %s\n", checkingBalance, savingsBalance, totalMoneyStored, numberOfAccounts);
    }

    private static String createAcctNum() {
        Random rand = new Random();
        String acctNum = "";
        for (int i = 0; i <10; i++) {
            int randomNum = rand.nextInt(10);
            acctNum += randomNum; 
        }
        return acctNum;
    }
}