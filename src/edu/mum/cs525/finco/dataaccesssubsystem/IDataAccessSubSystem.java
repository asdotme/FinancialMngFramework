package edu.mum.cs525.finco.dataaccesssubsystem;

import java.util.List;

import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;

/**
 * Created by asme on 2/6/17.
 */
public interface IDataAccessSubSystem {
	public   List<ITransaction> getTransactions();
	public   List<ICustomer> getCustomers();
	public  List<IAccount> getAccountList();
}
