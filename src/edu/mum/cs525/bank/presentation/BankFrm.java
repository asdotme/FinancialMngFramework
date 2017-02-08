package edu.mum.cs525.bank.presentation;


import java.awt.event.ActionEvent;

import edu.mum.cs525.finco.IFinCo;
import edu.mum.cs525.finco.presentation.FinCoJDialog_AddCompAcc;
import edu.mum.cs525.finco.presentation.FinCoJDialog_AddPAcc;
import edu.mum.cs525.finco.presentation.FinCoMainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class BankFrm extends FinCoMainFrame
{
	private static final long serialVersionUID = 8235385453103362093L;
	private JButton JButton_Addinterest = new JButton();
	IFinCo finco;
	JButton JButton_CompAC = new JButton();


	public BankFrm(IFinCo finco)
	{
		super(finco);
		this.finco=finco;

//		SymAction lSymAction = new SymAction();
//		JButton_CompAC.addActionListener(lSymAction);



//		SymAction lSymAction = new SymAction();
//		JButton_Addinterest.addActionListener(lSymAction);
	}


//	@Override
//	public void addComponents(){
//		JButton_Addinterest.setBounds(448, 20, 106, 33);
//		JButton_Addinterest.setText("Add interest");
//		JPanel1.add(JButton_Addinterest);
//	}
//
//
//	void JButtonAddinterest_actionPerformed(ActionEvent event) {
//		finco.addInterest();
//		JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts",
//				"Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
//	}
//
//	class SymAction implements java.awt.event.ActionListener {
//		public void actionPerformed(ActionEvent event) {
//			JButtonCompAC_actionPerformed(event);
//
//		}
//	}
//	protected void JButtonCompAC_actionPerformed(ActionEvent event) {
//		/*
//		 * construct a JDialog_AddCompAcc type object set the boundaries and
//		 * show it
//		 */
//
//		BankJDialog_AddCompAcc pac = new BankJDialog_AddCompAcc(this, finco);
//		pac.setBounds(450, 20, 300, 330);
//		pac.show();
//
//	}

	@Override
	protected void JButtonPerAC_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		FinCoJDialog_AddPAcc pac = new BankJDialog_AddPAcc(myframe, finco);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
	}

	@Override
	protected void JButtonCompAC_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		FinCoJDialog_AddCompAcc pac = new BankJDialog_AddCompAcc(myframe, finco);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
	}

	@Override
	protected void JButtonDeposit_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		super.JButtonDeposit_actionPerformed(event);
	}

	@Override
	protected void JButtonWithdraw_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		super.JButtonWithdraw_actionPerformed(event);
	}
	
	

}

