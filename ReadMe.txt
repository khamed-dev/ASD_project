The project contains three parts 
the Bank, the Ccard, and thier framework Finco,


____________________________________________________

The framework has its default GUI and CustomerAndAccountFactory;


____________________________________________________

the Bank extends from the framework (white box),  
and the Gui of the Bank extends from the framework's Gui, so we can customize the Bank's Gui,
we also implement the ICustomerAndAccountFactory; providing the way to create a customer and the type of the account for the Bank;
than we inject it in the framework,


____________________________________________________

the Ccard extends from the framework (white box),  
and the Gui of the Ccard extends from the framework's Gui, so we can customize the Ccard's Gui,
we also implement the ICustomerAndAccountFactory,
providing the way to create a customer and the type of the account for the Ccard
than we inject it in the framework,

