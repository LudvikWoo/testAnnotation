package com.guoyasoft.testNG.test;

import com.guoyasoft.testNG.annotations.TestNGSvc04;
import com.guoyasoft.testNG.buisiness.TestWebDriver;

public class Test {
	public static void main(String[] args) throws Exception {
		TestNGSvc04.dealTestNg(TestWebDriver.class);
	}
}