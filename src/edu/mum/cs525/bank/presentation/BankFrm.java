package edu.mum.cs525.bank.presentation;


import java.awt.event.ActionEvent;

import edu.mum.cs525.finco.IFinCo;
import edu.mum.cs525.finco.presentation.FinCoAddCompanyAccountDialog;
import edu.mum.cs525.finco.presentation.FinCoAddPersonAccountDialog;
import edu.mum.cs525.finco.presentation.FinCoMainFrame;

import javax.swing.*;


public class BankFrm extends FinCoMainFrame
{
	private static final long serialVersionUID = 8235385453103362093L;
	IFinCo finco;
	JButton JButton_CompAC = new JButton();


	public BankFrm(IFinCo finco)
	{
		super(finco);
		this.finco=finco;
	}
	@Override
	protected void JButtonPerAC_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		FinCoAddPersonAccountDialog pac = new BankJDialog_AddPAcc(myframe, finco);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
	}

	@Override
	protected void JButtonCompAC_actionPerformed(ActionEvent event) {
		FinCoAddCompanyAccountDialog pac = new BankJDialog_AddCompAcc(myframe, finco);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
	}

	@Override
	protected void JButtonDeposit_actionPerformed(ActionEvent event) {
		super.JButtonDeposit_actionPerformed(event);
	}

	@Override
	protected void JButtonWithdraw_actionPerformed(ActionEvent event) {
		super.JButtonWithdraw_actionPerformed(event);
	}
}

