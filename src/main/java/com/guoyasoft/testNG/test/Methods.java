package com.guoyasoft.testNG.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guoyasoft.testNG.annotations.AfterTest;
import com.guoyasoft.testNG.annotations.BeforeTest;

public class Methods {

	@BeforeTest
	public void method1() {
		System.out.println("method1");
	}

	@AfterTest
	public void method2() {
		System.out.println("method2");
	}

	@BeforeMethod
	public void method3() {
		System.out.println("method3");

	}

	@AfterMethod
	public void method4() {
		System.out.println("method4");

	}

	@Test
	public void method5() {
		System.out.println("method5");

	}

	@Test
	public void method6() {
		System.out.println("method6");

	}
}
