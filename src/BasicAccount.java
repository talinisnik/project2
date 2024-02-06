public class BasicAccount implements IAccount {
    private final int accountNumber;
    private final double withdrawalLimit;
    private double balance;

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.withdrawalLimit = (withdrawalLimit > 0) ? withdrawalLimit : 0;
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
        double allowedWithdrawal = Math.min(this.withdrawalLimit, amount);
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
