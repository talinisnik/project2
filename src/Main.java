public class Main {
    public static void main(String[] args) {
        // Create Standard Account with a credit limit of -100
        IAccount standard = new StandardAccount(1, -100);
        // Create Basic Account with a withdrawal limit of 100
        IAccount basic = new BasicAccount(2, 100);
        // Create a new Premium Account
        IAccount premium = new PremiumAccount(3);
        // Create a new bank
        IBank bank = new Bank();

        // Open those 3 accounts in the bank
        bank.openAccount(standard);
        bank.openAccount(premium);
        bank.openAccount(basic);

        // Deposit 1000 in each account
        System.out.println("Depositing 1000 in each account...");
        premium.deposit(1000);
        standard.deposit(1000);
        basic.deposit(1000);
        System.out.println("");

        System.out.println("Withdrawing 3000 from each account...");
        // Try to withdraw 3000 from the premium account (should print 3000)
        System.out.println("Withdrawn " + premium.withdraw(3000) + " From Premium Account");
        // Try to withdraw 3000 from the Basic account (should print 100)
        System.out.println("Withdrawn " + basic.withdraw(3000) + " From Basic Account");
        // Try to withdraw 3000 from the Standard account (should print 1100)
        System.out.println("Withdrawn " + standard.withdraw(3000) + " From Standard Account");
        System.out.println("");

        // Check Balance in Premium Account (Should print -2000)
        System.out.println("Current Balance in account number " + premium.getAccountNumber() + " (Premium) is " + premium.getCurrentBalance());
        // Check Balance in Basic Account (Should print 900)
        System.out.println("Current Balance in account number " + basic.getAccountNumber() + " (Basic) is " + basic.getCurrentBalance());
        // Check Balance in Standard Account (Should print -100)
        System.out.println("Current Balance in account number " + standard.getAccountNumber() + " (Standard) is " + standard.getCurrentBalance());
        System.out.println("");

        // Print all accounts in debt (should print accounts 1 and 3)
        System.out.println("Accounts in debt:");
        for (IAccount account : bank.getAllAccountsInDebt()) {
            System.out.println("Account " + account.getAccountNumber() + " is in debt");
        }
        System.out.println("");

        // Close All Bank Accounts
        System.out.println("Closing all accounts in the bank...");
        bank.closeAccount(premium.getAccountNumber());
        bank.closeAccount(basic.getAccountNumber());
        bank.closeAccount(standard.getAccountNumber());
        // check how many accounts are present in the bank (should be only 2 - cannot close accounts in debt)
        System.out.println("There are " + bank.getAllAccounts().size() + " accounts in the bank");
        System.out.println("");

        // Deposit 2000 to each of the accounts left
        System.out.println("Depositing 2000 in each account...");
        premium.deposit(2000);
        standard.deposit(2000);

        // Print all accounts with a balance more than 1000 (should print account 1 only)
        System.out.println("Accounts with a balance more than 1000:");
        for (IAccount account : bank.getAllAccountsWithBalance(1000)) {
            System.out.println("Account " + account.getAccountNumber() + " has more than 1000 in its balance");
        }
        System.out.println("");

        // Check Balance in Premium Account (Should print 0)
        System.out.println("Current Balance in account number " + premium.getAccountNumber() + " (Premium) is " + premium.getCurrentBalance());
        // Check Balance in Standard Account (Should print 1900)
        System.out.println("Current Balance in account number " + standard.getAccountNumber() + " (Standard) is " + standard.getCurrentBalance());

        // Close All Bank Accounts
        System.out.println("");
        System.out.println("Closing all bank accounts...");
        bank.closeAccount(premium.getAccountNumber());
        bank.closeAccount(standard.getAccountNumber());
        // check how many accounts are present in the bank (should be only 0)
        System.out.println("There are " + bank.getAllAccounts().size() + " accounts in the bank");
}
}