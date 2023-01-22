public class BasicAccount implements IAccount {
    private int accountNumber;
    private double withdrawalLimit;
    private double balance;

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.withdrawalLimit = withdrawalLimit;
        this.balance = 0;
    }

    @Override
    public void Deposit(double amount) {
        balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        double availableWithdrawal = Math.min(balance, withdrawalLimit);
        if (amount > availableWithdrawal) {
            amount = availableWithdrawal;
        }
        balance -= amount;
        return amount;
    }

    @Override
    public double GetCurrentBalance() {
        return balance;
    }

    @Override
    public int GetAccountNumber() {
        return accountNumber;
    }
}
