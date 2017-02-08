package edu.mum.cs525.bank.presentation;


import java.awt.event.ActionEvent;

import edu.mum.cs525.finco.IFinCo;
import edu.mum.cs525.finco.presentation.FinCoJDialog_AddCompAcc;
import edu.mum.cs525.finco.presentation.FinCoJDialog_AddPAcc;
import edu.mum.cs525.finco.presentation.FinCoMainFrame;


public class BankFrm extends FinCoMainFrame
{
	private static final long serialVersionUID = 8235385453103362093L;
    
	public BankFrm(IFinCo finco)
	{
		super(finco);
	}

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

