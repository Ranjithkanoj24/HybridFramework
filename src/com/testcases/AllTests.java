package com.testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	LoginLogout.class,
	CreateCustomer.class,
	CreateNewCustomer.class
})
public class AllTests {
	
	/*public static void main(String arrg[]){
		LoginLogout ll = new LoginLogout();
		System.out.println("Started LoginLogout test case execution");
		ll.callLoginLogout("LoginLogout");
		CreateCustomer cc = new CreateCustomer();
		cc.callCreateCustomer("CreateCustomer");
		CreateNewCustomer cnc = new CreateNewCustomer();
		cnc.callCreateCustomer("CreateNewCustomer");
	}*/

}
