import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {
    private List<IAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    @Override
    public void OpenAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void CloseAccount(int accountNumber) {
        IAccount accountToClose = null;
        for (IAccount account : accounts) {
            if (account.GetAccountNumber() == accountNumber) {
                accountToClose = account;
                break;
            }
        }
        if (accountToClose != null) {
            if (accountToClose.GetCurrentBalance() > 0) {
                accounts.remove(accountToClose);
            } else {
                System.out.println("Account is not closed due to debt.");
            }
        }
    }

    @Override
    public List<IAccount> GetALLAccounts() {
        return accounts;
    }

    @Override
    public List<IAccount> GetALLAccountsInDebt() {
        List<IAccount> inDebtAccounts = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() < 0) {
                inDebtAccounts.add(account);
            }
        }
        return inDebtAccounts;
    }

    @Override
    public List<IAccount> GetALLAccountsWithBalance(double balanceAbove) {
        List<IAccount> accountsWithSufficientBalance = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() > balanceAbove) {
                accountsWithSufficientBalance.add(account);
            }
        }
        return accountsWithSufficientBalance;
    }
}
