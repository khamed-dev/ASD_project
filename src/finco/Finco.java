package finco;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.UIManager;

import bank.BankCustomerAndAccountFactory;

import java.util.Scanner;

import framework.exceptions.WithdrawException;
import framework.interfaces.ICustomerAndAccountFactory;

public class Finco {
	protected static FincoGui gui=null;
	
	protected Finco( FincoGui gui, ICustomerAndAccountFactory abstractFactory){
		this.gui=gui;
		gui.setICustomerAndAccountFactory(abstractFactory);
		gui.setVisible(true);
		
		
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws WithdrawException, InterruptedException {
		ICustomerAndAccountFactory f=null;
		Class instance=null;
		try {
			Scanner scanner = new Scanner(new File("fincoConfig.txt"));
			
			String instanceName = scanner.nextLine();
			 instance = Class.forName(instanceName);
			 System.out.println(instanceName);
			 f= (ICustomerAndAccountFactory) instance.newInstance();

			 
			 instanceName = scanner.nextLine();
			 System.out.println(instanceName);
			 instance = Class.forName(instanceName);
			 
			 
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		    
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }
		    
			//Create a new instance of our application's frame, and make it visible.
		    new Finco((FincoGui) instance.newInstance(), f);
			
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
		
	
		
	}
}
