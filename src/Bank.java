import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {
    private final List<IAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    @Override
    public void openAccount(IAccount account) {
        accounts.add(account);
        System.out.println("Debug: Opening account with number " + account.getAccountNumber());
    }

    @Override
    public void closeAccount(int accountNumber) {
        IAccount foundAccount = null;
        for (IAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                foundAccount = account;
                break;
            }
        }

        if (foundAccount != null) {
            if (foundAccount.getCurrentBalance() > 0) {
                accounts.remove(foundAccount);
            } else {
                System.out.println("Account cannot be closed due to debt.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public List<IAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public List<IAccount> getAllAccountsInDebt() {
        List<IAccount> accountsInDebt = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.getCurrentBalance() < 0) {
                accountsInDebt.add(account);
            }
        }
        return accountsInDebt;
    }

    @Override
    public List<IAccount> getAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> accountsWithBalance = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.getCurrentBalance() > balanceAbove) {
                accountsWithBalance.add(account);
            }
        }
        return accountsWithBalance;
}
}