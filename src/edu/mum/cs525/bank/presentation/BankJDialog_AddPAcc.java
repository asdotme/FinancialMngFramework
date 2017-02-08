package edu.mum.cs525.bank.presentation;/*
		A basic implementation of the JDialog class.
*/

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

import edu.mum.cs525.bank.accountsubsystem.controller.CheckingAccountVisitor;
import edu.mum.cs525.bank.accountsubsystem.controller.SavingAccountVisitor;
import edu.mum.cs525.finco.IFinCo;
import edu.mum.cs525.finco.customersubsystem.model.Address;
import edu.mum.cs525.finco.customersubsystem.model.IAddress;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;
import edu.mum.cs525.finco.customersubsystem.model.Person;
import edu.mum.cs525.finco.presentation.FinCoJDialog_AddPAcc;
import edu.mum.cs525.finco.presentation.FinCoMainFrame;

public class BankJDialog_AddPAcc extends FinCoJDialog_AddPAcc
{
	private static final long serialVersionUID = -8144103120067984196L;
    
	public BankJDialog_AddPAcc(FinCoMainFrame parent, IFinCo finco)
	{
		super(parent, finco);
		
		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parse your Java file into its visual environment.
		//{{INIT_CONTROLS
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36,0,84,24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36,24,84,24);
		
		JTextField_BD.setBounds(84,228,156,20);
		JTextField_BD.setText("7-Jun-1990");
		JLabel7.setText("BirthDay");
		getContentPane().add(JLabel7);
		getContentPane().add(JTextField_BD);
		JLabel7.setForeground(Color.black);
		JLabel7.setBounds(12,228,48,24);
	}

	//{{DECLARE_CONTROLS
	JRadioButton JRadioButton_Chk = new JRadioButton();
	JRadioButton JRadioButton_Sav = new JRadioButton();
	protected JLabel JLabel7 = new JLabel();
	protected JTextField JTextField_BD = new JTextField();
	@Override
	protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		String accountNumber =JTextField_ACNR.getText();
		String name =JTextField_NAME.getText();
		String street=JTextField_STR.getText();
		String city = JTextField_CT.getText();
		String zip=JTextField_ZIP.getText();
		String state=JTextField_ST.getText();
		String birthDate = JTextField_BD.getText();
		String email = JTextField_EM.getText();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = null;
		try {
			date = formatter.parse(birthDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//TODO: Creating objects shouldnt be done here unless for meeting a deadline.
		//A factory of Spring DI can be used
        
		IAddress address = new Address(state, city, street, zip); 

		IPerson person = new Person(address, name, date, email);
		person.setAddress(address);
		
		if(JRadioButton_Chk.isSelected())
			finco.setAccountVisitor(new CheckingAccountVisitor());
		else
			finco.setAccountVisitor(new SavingAccountVisitor());
		
		finco.addPersonAccount(person, accountNumber);
		
       dispose();
	}
}