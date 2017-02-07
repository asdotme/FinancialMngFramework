package edu.mum.cs525.finco;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import edu.mum.cs525.finco.accountsubsystem.controller.AccountController;
import edu.mum.cs525.finco.accountsubsystem.controller.CompanyEvaluatorFunctor;
import edu.mum.cs525.finco.accountsubsystem.controller.EvaluateFunctor;
import edu.mum.cs525.finco.accountsubsystem.controller.IAccountController;
import edu.mum.cs525.finco.accountsubsystem.controller.IAccountVisitor;
import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.customersubsystem.controller.CustomerController;
import edu.mum.cs525.finco.customersubsystem.controller.ICustomerController;
import edu.mum.cs525.finco.customersubsystem.model.IAddress;
import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;
import edu.mum.cs525.finco.dataaccesssubsystem.DataAccessSubSystem;
import edu.mum.cs525.finco.dataaccesssubsystem.IDataAccessSubSystem;
import edu.mum.cs525.finco.presentation.FinCoMainFrame;

/**
 * Created by asme on 2/6/17.
 */
public class FinCo implements IFinCo {

    IAccountController accountController;
    ICustomerController customerController;
    protected DefaultTableModel defaultTableModel;
    EvaluateFunctor evaluateFuctor;
    String amountColumnLabel = "Amount";

    
    public FinCo(IAccountController accountController,ICustomerController customerController) {
		this.accountController = accountController;
		this.customerController = customerController;
	}

    public FinCo() {
		this.accountController = new AccountController();
		this.customerController= new CustomerController();
	}
    
	@Override
    public void addAccount(IAccountVisitor accountVisitor, ICustomer customer) {

    }

    @Override
    public void withdrawMoney(IAccount account) {
        account.withdraw(null);
    }

    @Override
    public void addInterest() {
        accountController.addInterest();
        refreshDataTableRows();
    }

    @Override
    public void generateReport(IAccount account) {
    	
    }


    public static void main(String[] args) {
    	IAccountController acctController = new AccountController();
    	acctController.setDbStore(new DataAccessSubSystem()); //set the database system
        FinCo finco = new FinCo(acctController);
        
        String[] dataTableCols = {"AccountNo", "Name", "Type", "Balance"};
        finco.initializeFincoApp(dataTableCols);

    }

    private void initializeFincoApp(String[] dataTableCols) {
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
        new FinCoMainFrame(this).setVisible(true);
        ;

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
		rowdata[2] = address.getCity();
		rowdata[3] = customer.getType();
		// rowdata[4] = accountType;
		rowdata[4] = account.getAccountBalance();
		defaultTableModel.addRow(rowdata);
    }

    @Override
    public void depositeMoney(IAccount account, int selectedIndex, double amount) {
        int ammountColIndex = defaultTableModel.findColumn(getAmountColumnLabel());
        double newamount = (double) defaultTableModel.getValueAt(selectedIndex, ammountColIndex) + amount;
        defaultTableModel.setValueAt(newamount, selectedIndex, ammountColIndex); //put the value in selected row and column
        if (amount < 0 && newamount < 0) {
            JOptionPane
                    .showMessageDialog(null,
                            "No enough money in person account",
                            "Invalid deposit attempt!"
                            , JOptionPane.WARNING_MESSAGE);
        }

        //update the model and the account, push it also into the database

    }

    public String getAmountColumnLabel() {
        return amountColumnLabel;
    }

    public void setAmountColumnLabel(String amountColumnLabel) {
        this.amountColumnLabel = amountColumnLabel;
    }

    @Override
    public void withdrawMoney(IAccount account, int rowIndex, double amountToWithdraw) {
        int ammountColIndex = defaultTableModel.findColumn(getAmountColumnLabel());
        double currentAmount = (double) defaultTableModel.getValueAt(rowIndex, ammountColIndex);

        if (currentAmount < amountToWithdraw) {
            JOptionPane
                    .showMessageDialog(null,
                            "No enough money to make this withdraw",
                            "Insufficient balance!"
                            , JOptionPane.WARNING_MESSAGE);
        } else {
            System.out.println("Not possible");
        }
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

	@Override
	public void addCustomer(ICustomer customer) {
		int accountNumber = accountController.getAccounts().size() + 1;
//		accountController.createCompanyAccount(, company, accountNumber);
	}

	public EvaluateFunctor getEvaluateFuctor() {
		return evaluateFuctor;
	}

	public void setEvaluateFuctor(EvaluateFunctor evaluateFuctor) {
		this.evaluateFuctor = evaluateFuctor;
	}

	@Override
	public void addCompanyAccount(IAccountVisitor accountVisitor, ICompany company, String accountNumber) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void addPersonAccount(IAccountVisitor accountVisitor, IPerson person, String accountNumber) {
		// TODO Auto-generated method stub
		
	}
	
}



