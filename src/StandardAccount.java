public class StandardAccount implements IAccount {
    private int accountNumber;
    private double creditLimit;
    private double balance;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        if (creditLimit > 0) {
            this.creditLimit = 0;
        } else {
            this.creditLimit = creditLimit;
        }
        this.balance = 0;
    }

    @Override
    public void Deposit(double amount) {
        balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        double availableWithdrawal = balance + creditLimit;
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
