package finalproject.model.logger;

import finalproject.model.account.IAccount;

/**
 * Created by asme on 2/5/17.
 */
public abstract class AccountLogger implements IAccount {
    IAccount iAccount;
    public AccountLogger(IAccount iAccount){
        this.iAccount=iAccount;
    }
    public void preExecute(){

    }
    public void addEntry(){

        iAccount.addEntry();
    }
    public void postExecute(){

    }
}
