public class TestBankAccount {

    public static void main(String[] args) {
        System.out.println("---- Get Account1 Details ----");
        BankAccount account1 = new BankAccount();
        account1.deposit("checking", 99.99);
        account1.deposit("savings", 15263.23);
        account1.getBalances();
        System.out.printf("Account Number: %s", account1.getAccountNumber());

        System.out.println("\n---- Add Account2 and See Updated Details ----");
        BankAccount account2 = new BankAccount();
        account2.deposit("checking",1000);
        account2.deposit("savings",100);
        account2.getBalances();
        System.out.printf("Account Number: %s", account2.getAccountNumber());
        System.out.println(BankAccount.numberOfAccounts);

        account2.withdraw("checking", 1500);
        account2.withdraw("savings",500);

        account2.withdraw("savings",100);
        account2.getBalances();
    }
}