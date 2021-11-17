package framework.interfaces;

import framework.account.Account;

public interface ICustomerAndAccountFactory {
	ICustomer createCustomer(String string, String clientName, String city, Account account);
	IAccount createAccount(String type, String accNumber);

}
