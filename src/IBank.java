import java.util.List;

public interface IBank {void OpenAccount (IAccount account);
        void CloseAccount (int accountNumber);
        List<IAccount> GetALLAccounts();
        List<IAccount> GetALLAccountsInDebt();
        List <IAccount> GetALLAccountsWithBalance (double balanceAbove);
}


