public class StandardAccount implements IAccount {
    private final int accountNumber;
    private final double creditLimit;
    private double balance;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        this.creditLimit = (creditLimit < 0) ? creditLimit : 0;
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
        double allowedWithdrawal = Math.min(this.balance + this.creditLimit, amount);
        // נמשיך רק אם יש יתרה לסכום המשיכה
        if (allowedWithdrawal >= 0) {
            // נמשיך רק אם יש יתרה לסכום המשיכה
            this.balance -= allowedWithdrawal;
        }
        // נחזיר את הסכום הממושך
        return allowedWithdrawal;
    }

    @Override
    public double getCurrentBalance() {
        // נחזיר את היתרה הנוכחית
        return this.balance;
    }

    @Override
    public int getAccountNumber() {
        // נחזיר את מספר החשבון
        return this.accountNumber;
}
}