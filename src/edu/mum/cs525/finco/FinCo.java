package edu.mum.cs525.finco;

import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import edu.mum.cs525.finco.accountsubsystem.controller.AccountController;
import edu.mum.cs525.finco.accountsubsystem.controller.AccountVisitor;
import edu.mum.cs525.finco.accountsubsystem.controller.EvaluateFunctor;
import edu.mum.cs525.finco.accountsubsystem.controller.IAccountController;
import edu.mum.cs525.finco.accountsubsystem.controller.IAccountVisitor;
import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;
import edu.mum.cs525.finco.customersubsystem.controller.CustomerController;
import edu.mum.cs525.finco.customersubsystem.controller.ICustomerController;
import edu.mum.cs525.finco.customersubsystem.model.IAddress;
import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;
import edu.mum.cs525.finco.dataaccesssubsystem.DataAccessSubSystem;
import edu.mum.cs525.finco.presentation.FinCoMainFrame;
import edu.mum.cs525.finco.presentation.Mediator;

/**
 * Created by asme on 2/6/17.
 */
public class FinCo implements IFinCo {

    protected IAccountController accountController;
    protected ICustomerController customerController;
    protected DefaultTableModel defaultTableModel;
    protected IAccountVisitor accountVisitor;
    EvaluateFunctor evaluateFuctor;
    String amountColumnLabel = "Amount";
    Mediator mediator;

    
    public FinCo(IAccountController accountController,ICustomerController customerController) {
		this.accountController = accountController;
		this.customerController = customerController;
	}

    public FinCo() {
		this.accountController = new AccountController();
		this.customerController= new CustomerController();
	}
    


    @Override
    public void withdrawMoney(IAccount account, ITransaction transaction) {
    	accountController.withdrawMoney(transaction, account);
    	refreshDataTableRows();
    	mediator.checkOperationState();
    }

    @Override
    public void addInterest() {
        accountController.addInterest();
        refreshDataTableRows();
    }

    @Override
    public String generateReport(IAccount account) {
    	return account.generateReport();
    }


    public static void main(String[] args) {
    	IAccountController acctController = new AccountController();
    	acctController.setDbStore(new DataAccessSubSystem()); //set the database system
        FinCo finco = new FinCo();
        finco.setAccountVisitor(new AccountVisitor()); //set default account visitor
        
        String[] dataTableCols = {"AccountNo", "Name", "Type", "Balance"};
        finco.initializeFincoApp(dataTableCols, "FinCo application");

    }

    protected void initializeFincoApp(String[] dataTableCols, String applicationTitle) {
        //initialize defaultdatatablecolumn
        defaultTableModel = new DefaultTableModel();
        for (String colName : dataTableCols) {
            defaultTableModel.addColumn(colName);
        }
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        this.setDefaultTableModel(defaultTableModel);
        FinCoMainFrame frame = new FinCoMainFrame(this);
        frame.setTitle(applicationTitle);
        mediator = new Mediator(frame);
        mediator.checkOperationState();
        frame.setVisible(true);
        

    }

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
        this.defaultTableModel = defaultTableModel;
    }

    public void addRow(IAccount account) {
		ICustomer customer = account.getAccountOwner();
		IAddress address = customer.getAddress();
		Object rowdata[] = new Object[defaultTableModel.getColumnCount()];
		rowdata[0] = account;
		rowdata[1] = customer.getName();
		rowdata[2] = customer.getType();
		rowdata[3] = account.getAccountBalance();
		defaultTableModel.addRow(rowdata);
    }

    @Override
    public void depositeMoney(IAccount account, ITransaction transaction) {
    	accountController.depositeMoney(transaction, account);
    	refreshDataTableRows();
    	mediator.checkOperationState();
    }

    public String getAmountColumnLabel() {
        return amountColumnLabel;
    }

    public void setAmountColumnLabel(String amountColumnLabel) {
        this.amountColumnLabel = amountColumnLabel;
    }

    
    public void refreshDataTableRows(){
    	if (defaultTableModel.getRowCount() > 0) {
			for (int i = defaultTableModel.getRowCount() - 1; i > -1; i--) {
				defaultTableModel.removeRow(i);
			}
		}
		List<IAccount> accounts = accountController.getAccounts();

		for (IAccount account : accounts)
			addRow(account);
    }

	/*@Override
	public void addCustomer(ICustomer customer) {
		int accountNumber = accountController.getAccounts().size() + 1;
//		accountController.createCompanyAccount(, company, accountNumber);
	}*/

	public EvaluateFunctor getEvaluateFuctor() {
		return evaluateFuctor;
	}

	public void setEvaluateFuctor(EvaluateFunctor evaluateFuctor) {
		this.evaluateFuctor = evaluateFuctor;
	}

	@Override
	public void addCompanyAccount(ICompany company, String accountNumber) {
		accountController.createCompanyAccount(accountVisitor, company, accountNumber);
		addRow(accountController.getAccount(accountNumber));
	
	}

	@Override
	public void addPersonAccount(IPerson person, String accountNumber) {
		accountController.createPersonAccount(new AccountVisitor(), person, accountNumber);	
		addRow(accountController.getAccount(accountNumber));
	}

	@Override
	public IAccount getAccountFromAccountNumber(String accountNumber) {
		IAccount account=accountController.getAccount(accountNumber);
		return account;	
	}

	@Override
	public void updateUICommands() {
		mediator.checkOperationState();
	}

	public IAccountVisitor getAccountVisitor() {
		return accountVisitor;
	}

	public void setAccountVisitor(IAccountVisitor accountVisitor) {
		this.accountVisitor = accountVisitor;
	}
	
	
	
	
}



