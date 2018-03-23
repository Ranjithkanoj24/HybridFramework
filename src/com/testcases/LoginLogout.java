package com.testcases;

import org.junit.Test;

import com.practise.session1.TestExecutor;

public class LoginLogout {
	@Test
	public void callLoginLogout() {
		System.out.println("Starting LoginLogout class");
		TestExecutor tex = new TestExecutor();
		tex.executeTest("LoginLogout");
		System.out.println("Completed LoginLogout class");

	}

}