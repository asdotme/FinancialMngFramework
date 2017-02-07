package edu.mum.cs525.finco.accountsubsystem.model;

import java.util.Date;

/**
 * Created by asme on 2/5/17.
 */
public interface ITransaction {
	 public double getTransactionAmount();

	    public TransactionType getTransactionType() ;

	    public Date getTransactionDate() ;
}
