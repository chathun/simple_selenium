package com.tokbox.utilities;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * This class defines custom logging messages for TestListsnerAdapter
 * Custom messages are displayed for Passed, Failed and Skipped tests
 */
public class ListenerClass extends TestListenerAdapter {

	@Override
	public void onTestSuccess(ITestResult tr) {

		log("Test '" + tr.getName() + "' PASSED");

	}

	@Override
	public void onTestFailure(ITestResult tr) {

		log("Test '" + tr.getName() + "' FAILED");

	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		log("Test '" + tr.getName() + "' SKIPPED");

	}

	private void log(String methodName) {
		System.out.println(methodName);
	}

}
