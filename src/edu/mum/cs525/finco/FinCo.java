package edu.mum.cs525.finco;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import edu.mum.cs525.finco.accountsubsystem.controller.IAccountController;
import edu.mum.cs525.finco.accountsubsystem.controller.IAccountVisitor;
import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.Transaction;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;

/**
 * Created by asme on 2/6/17.
 */
public class FinCo implements IFinCo {

    IAccountController accountController;
    protected DefaultTableModel defaultTableModel;
    String amountColumnLabel = "Amount";

    @Override
    public void addAccount(IAccountVisitor accountVisitor, ICustomer customer) {

    }

    @Override
    public void withdrawMoney(IAccount account) {
        account.withdraw(new Transaction());
    }

    @Override
    public void addInterest() {
        accountController.addInterest();
    }

    @Override
    public void generateReport(IAccount account) {

    }


    public static void main(String[] args) {
        FinCo finco = new FinCo();
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
//		ICustomer customer = account.getiCustomer();
//		IAddress address = customer.getAddress();
//		Object rowdata[] = new Object[mainFormTableModel.getColumnCount()];
//		rowdata[0] = account;
//		rowdata[1] = customer.getName();
//		rowdata[2] = address.getCity();
//		rowdata[3] = customer.getType();
//		// rowdata[4] = accountType;
//		rowdata[4] = account.getBalance();
//		mainFormTableModel.addRow(rowdata);
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
}



