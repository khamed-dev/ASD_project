package ccard;
import framework.account.Account;
import framework.customer.Company;
import framework.customer.Personal;
import framework.interfaces.IAccount;
import framework.interfaces.ICustomer;
import framework.interfaces.ICustomerAndAccountFactory;

public class CcardCustomerAndAccountFactory implements ICustomerAndAccountFactory {

	@Override
	public ICustomer createCustomer(String type, String clientName, String city, Account account) {
		return new Personal(clientName,city,account);
	
	}

	@Override
	public IAccount createAccount(String type, String accNumber) {
		switch(type) {
		case "Gold": return new Gold(accNumber) ;
		case "Silver": return new Silver(accNumber);
		case "Bronze": return new Bronze(accNumber);
		}
		return null;
	}

	

}
