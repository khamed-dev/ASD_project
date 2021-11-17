package ccard;

import javax.swing.table.DefaultTableModel;

import finco.FincoGui;
import framework.account.Account;
import framework.customer.Customer;
import framework.interfaces.ICustomer;

public class CcardGui extends FincoGui{
	String expdate, ccnumber;
	javax.swing.JButton JButton_NewCCAccount = new javax.swing.JButton();
	javax.swing.JButton JButton_GenBill = new javax.swing.JButton();
	
	public CcardGui() {
		super();
		myframe=this;
		
		
		setTitle("Credit-Card Processing Application.");
		lSymAction = new CcardSymAction();
		JPanel1.remove(JButton_PerAC);
		JButton_Withdraw.setText("Charge");
		
		JButton_NewCCAccount.setText("Add Credit-card account"); 
		JPanel1.add(JButton_NewCCAccount);
		JButton_NewCCAccount.setActionCommand("jbutton");
		JButton_NewCCAccount.setBounds(24,20,192,33);
		
		JButton_GenBill.setText("Generate Monthly bills");
		JPanel1.add(JButton_GenBill);
		JButton_GenBill.setActionCommand("jbutton");
		JButton_GenBill.setBounds(240,20,192,33);
		
		JButton_NewCCAccount.addActionListener(lSymAction);
		JButton_GenBill.addActionListener(lSymAction); // diff


		
		
	}
	
	
	
	@Override
	protected DefaultTableModel createModel() {
		DefaultTableModel model1 = new DefaultTableModel();
		   model1.addColumn("Name");
	        model1.addColumn("CC number");
	        model1.addColumn("Exp date"); // we dont have this on Bank
	        model1.addColumn("Type");
	        model1.addColumn("Balance");

		return model1;
	}
	
	class CcardSymAction extends SymAction {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			super.actionPerformed(event);
			Object object = event.getSource();
			 if (object == JButton_NewCCAccount)
				JButtonNewCCAC_actionPerformed(event);
			else if (object == JButton_GenBill)
				JButtonGenerateBill_actionPerformed(event);

		}
	}
	
	
	
	
	void JButtonNewCCAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		*/
		
		JDialog_AddCCAccount ccac = new JDialog_AddCCAccount(myframe);
		ccac.setBounds(450, 20, 300, 380);
		ccac.show();

		if (newaccount){
            // add row to table
			createNewCustomer(ccnumber, clientName, expdate, "", accountType);
           
        }

       
        
    }
	
	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event)
	{
		JDialogGenBill billFrm = new JDialogGenBill();
		billFrm.setBounds(450, 20, 400, 350);
		billFrm.show();
	    
	}
	@Override
	protected String getAccountNumber(int selection) {
		return (String) model.getValueAt(selection, 1);
	}
	
	
	
	protected void createNewCustomer(String ccnumber, String clientName, String expdate, String type,
			String accountType) {
		// add row to table

		Account account = (Account) customerAndAccountFactory.createAccount(accountType, ccnumber);
		ICustomer customer = customerAndAccountFactory.createCustomer(type, clientName, expdate, account);
		account.setCustomer(customer);
		// ((Customer) customer).addAccount(account);
		customerList.add((Customer) customer);

		customerList.forEach(System.out::println);
		 rowdata[0] = clientName;
         rowdata[1] = ccnumber;
         rowdata[2] = expdate;
         rowdata[3] = accountType;
         rowdata[4] = "0";
         model.addRow(rowdata);
         JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
         newaccount=false;

	}
	
	
	
	


}
