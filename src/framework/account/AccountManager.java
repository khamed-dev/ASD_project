package framework.account;

import framework.exceptions.WithdrawException;
import framework.interfaces.ICommand;

public class AccountManager {
	
	private ICommand command;
	
	
	public void setCommand(ICommand command) {
		this.command = command;
	}
	
	public void doTransaction(double value) throws WithdrawException {
		this.command.execute(value);	
	}

}
