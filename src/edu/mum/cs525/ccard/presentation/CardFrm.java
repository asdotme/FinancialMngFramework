package edu.mum.cs525.ccard.presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;

import edu.mum.cs525.finco.IFinCo;
import edu.mum.cs525.finco.presentation.FinCoJDialog_AddCompAcc;
import edu.mum.cs525.finco.presentation.FinCoMainFrame;

import javax.swing.*;

/**
 * A basic JFC based application.
 */
public class CardFrm extends FinCoMainFrame
{
	private static final long serialVersionUID = -7628963601322300516L;
	
    private DefaultTableModel model;
    private JTable JTable1;
    CardFrm thisframe;
    IFinCo finco;

	public CardFrm(IFinCo finco)
	{
		super(finco);
		thisframe=this;
		this.finco = finco;
		
		setTitle("Credit-card processing Application.");
	
//		JButton_NewCCAccount.setText("Add Credit-card accountsubsystem");
		JButton_Withdraw.setBounds(468, 150, 96, 33);
		JButton_Withdraw.setText("Charge");
		JButton_GenBill.setText("Generate Monthly bills");
		JButton_GenBill.setActionCommand("jbutton");
		JPanel1.add(JButton_GenBill);
		JButton_GenBill.setBounds(240,20,192,33);
		
		JButton_GenBill.setActionCommand("jbutton");

		SymAction lSymAction = new SymAction();
		JButton_GenBill.addActionListener(lSymAction);
		
	}

	JButton JButton_GenBill = new JButton();
	


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object object = event.getSource();
			
			if (object == JButton_GenBill)
				JButtonGenerateBill_actionPerformed(event);
			
		}	
		
	}

	void JButtonNewCCAC_actionPerformed(ActionEvent event)
	{
		CCardJDialog_AddCCAccount pac = new CCardJDialog_AddCCAccount(myframe, finco);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

       
        
    }

	void JButtonGenerateBill_actionPerformed(ActionEvent event)
	{
		//get the selected account
		//generate the bill
		CCardJDialogGenBill billFrm = new CCardJDialogGenBill();
		billFrm.setBounds(450, 20, 400, 350);
		billFrm.show();
	    
	}
//	class SymAction implements java.awt.event.ActionListener {
//		public void actionPerformed(ActionEvent event) {
//				JButtonAddinterest_actionPerformed(event);
//
//		}
//	}


}
	

