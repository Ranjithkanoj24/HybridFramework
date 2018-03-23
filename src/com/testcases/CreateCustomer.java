package com.testcases;

import org.junit.Test;

import com.practise.session1.TestExecutor;

public class CreateCustomer {
	@Test
	public void callCreateCustomer() {
		System.out.println("Starting CreateCustomer class");
		TestExecutor tex = new TestExecutor();
		tex.executeTest("CreateCustomer");
		System.out.println("Completed CreateCustomer class");

	}
}
