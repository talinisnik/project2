public class PremiumAccount implements IAccount {
    private final int accountNumber;
    private double balance;

    public PremiumAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    @Override
    public void deposit(double amount) {
        // נוסיף את הסכום ליתרת החשבון
        this.balance += amount;
    }

    @Override
    public double withdraw(double amount) {
        // נבדוק אם המשתמש יכול למשוך את הסכום המבוקש
        // כאן אין הגבלה על המשיכה
        if (amount >= 0) {
            // נמשיך רק אם יש יתרה לסכום המשיכה
            this.balance -= amount;
            // נחזיר את הסכום הממושך
            System.out.println("Debug: Withdrew " + amount + " from account number " + accountNumber);
            return amount;
        } else {
            // במקרה של משיכה שלילית, נחזיר 0
            System.out.println("Debug: Attempted to withdraw negative amount from account number " + accountNumber);
            return 0;
        }
    }

    @Override
    public double getCurrentBalance() {
        // נחזיר את היתרה הנוכחית
        System.out.println("Debug: Current balance of account number " + accountNumber + " is " + balance);
        return this.balance;
    }

    @Override
    public int getAccountNumber() {
        // נחזיר את מספר החשבון
        System.out.println("Debug: Account number is " + accountNumber);
        return this.accountNumber;
}
}