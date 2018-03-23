package com.testcases;

import org.junit.Test;

import com.practise.session1.TestExecutor;

public class CreateNewCustomer {
	@Test
	public void callCreateCustomer() {
		System.out.println("Starting CreateNewCustomer class");
		TestExecutor tex = new TestExecutor();
		tex.executeTest("CreateNewCustomer");
		System.out.println("Completed CreateNewCustomer class");

	}
}
