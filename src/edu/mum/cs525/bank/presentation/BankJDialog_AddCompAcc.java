package edu.mum.cs525.bank.presentation;

import java.awt.event.ActionEvent;

import javax.swing.*;

import edu.mum.cs525.bank.accountsubsystem.controller.CheckingAccountVisitor;
import edu.mum.cs525.bank.accountsubsystem.controller.SavingAccountVisitor;
import edu.mum.cs525.finco.IFinCo;
import edu.mum.cs525.finco.accountsubsystem.controller.IAccountVisitor;
import edu.mum.cs525.finco.customersubsystem.model.Address;
import edu.mum.cs525.finco.customersubsystem.model.Company;
import edu.mum.cs525.finco.customersubsystem.model.IAddress;
import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.presentation.FinCoJDialog_AddCompAcc;
import edu.mum.cs525.finco.presentation.FinCoMainFrame;



public class BankJDialog_AddCompAcc extends FinCoJDialog_AddCompAcc
{

	private static final long serialVersionUID = 5744267802974372124L;
    
	public BankJDialog_AddCompAcc(FinCoMainFrame parent, IFinCo finco)
	{
		super(parent, finco);
//		Helper.pushControls(this, 40);
		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parse your Java file into its visual environment.
		//{{INIT_CONTROLS
		
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36,12,84,24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36,36,84,24);
		System.out.println("get content pane object is from bank"+ getContentPane());

	}

	@Override
	protected void JButtonOK_actionPerformed(ActionEvent event) {
		String accountNumber=JTextField_ACNR.getText();
		String name = JTextField_NAME.getText();
		String street =JTextField_STR.getText();
		String city =JTextField_CT.getText();
		String zip=JTextField_ZIP.getText();
		String state=JTextField_ST.getText();
		int numberOfEmployee = Integer.valueOf(JTextField_NoOfEmp.getText());
		String email = JTextField_EM.getText();
		
		IAddress address = new Address(state, city, street, zip); 

		ICompany company = new Company(address, name, numberOfEmployee, email);
		company.setAddress(address);

		IAccountVisitor visitor;
		if(JRadioButton_Chk.isSelected())
			visitor=new CheckingAccountVisitor();
//			finco.setAccountVisitor(new CheckingAccountVisitor());
		else

			visitor=new SavingAccountVisitor();
//			finco.setAccountVisitor(new SavingAccountVisitor());

		finco.addCompanyAccount(visitor,company, accountNumber);

	}


	//{{DECLARE_CONTROLS
	JRadioButton JRadioButton_Chk = new JRadioButton();
	JRadioButton JRadioButton_Sav = new JRadioButton();
}
