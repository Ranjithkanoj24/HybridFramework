package com.practise.session1;

import org.junit.runner.JUnitCore;

public class Init {

	public static void main(String[] args) throws ClassNotFoundException {
		ExcelHandling eh = new ExcelHandling();
		JUnitCore core = new JUnitCore();
		int noOfScenarios = eh.getExcelRowCount("Scenarios");
		for(int i=1;i<=noOfScenarios;i++){
			String result = eh.readExcelData("Scenarios", i, 1);
			if(result.equalsIgnoreCase("Yes")){
				String scriptName = eh.readExcelData("Scenarios", i, 0);
				System.out.println(scriptName);
				Class classtoRun = Class.forName("com.testcases."+scriptName);
			}
		}

	}

}
