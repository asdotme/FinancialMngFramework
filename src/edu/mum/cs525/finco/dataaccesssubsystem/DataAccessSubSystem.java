package edu.mum.cs525.finco.dataaccesssubsystem;

import edu.mum.cs525.finco.accountsubsystem.model.IAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asme on 2/6/17.
 */
public class DataAccessSubSystem implements IDataAccessSubSystem {
    static List<IAccount> accountList=new ArrayList<>();

    public static List<IAccount> getAccounts() {
        return null;
    }
    
    public static void addAccounts(IAccount account) {
        accountList.add(account);
    }
    
    public static void addAllAccounts(List<IAccount> accounts) {
        accountList.addAll(accounts);
    }
}
