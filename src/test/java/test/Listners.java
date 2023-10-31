package test;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listners implements ITestListener{
	public void onTestStart(ITestResult result) {
		System.out.println("On Test Start"+result.getName());
	}
	public void OnTestSuccess(ITestResult result) {
		System.out.println("On Test Success"+result.getName());
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Fail"+result.getName());
	}
	public void onTestSkiped(ITestResult result) {
		System.out.println("On Test Skipped"+result.getName());
	}
	public void onTestFinish(ITestResult result) {
		System.out.println("OnTest Finish"+result.getName());
	}

}
