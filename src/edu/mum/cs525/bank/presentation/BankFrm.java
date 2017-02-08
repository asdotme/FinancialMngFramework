package edu.mum.cs525.bank.presentation;


import java.awt.event.ActionEvent;

import edu.mum.cs525.finco.IFinCo;
import edu.mum.cs525.finco.presentation.FinCoMainFrame;


public class BankFrm extends FinCoMainFrame
{
	private static final long serialVersionUID = 8235385453103362093L;
    String accountnr, clientName,street,city,zip,state,accountType,clientType,amountDeposit;
    boolean newaccount;
    BankFrm myframe;
    
	public BankFrm(IFinCo finco)
	{
		super(finco);
	}

	@Override
	protected void JButtonPerAC_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		super.JButtonPerAC_actionPerformed(event);
	}

	@Override
	protected void JButtonCompAC_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		super.JButtonCompAC_actionPerformed(event);
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
