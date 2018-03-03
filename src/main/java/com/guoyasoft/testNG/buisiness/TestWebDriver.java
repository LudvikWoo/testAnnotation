package com.guoyasoft.testNG.buisiness;

import org.openqa.selenium.WebDriver;

import com.guoyasoft.testNG.annotations.BeforeTest;
import com.guoyasoft.testNG.annotations.Test;

public class TestWebDriver {
	private WebDriver driver;
	
	@BeforeTest
	public void startChrome(){
		System.out.println("------启动浏览器成功----------");
	}
	
	@Test(priority=2)
	public void testButton(){
		System.out.println("------测试button成功----------");
	}
	
	@Test(priority=1,loop=3)
	public void testFile(){
		System.out.println("------测试file成功----------");
	}
	
	//@Test(priority=3)
	public void testSelect(){
		System.out.println("------测试select成功----------");
	}
	
	//@AfterTest
	public void shutdownChrome(){
		System.out.println("------关闭浏览器成功----------");
	}
	
	@Test(loop=10)
	public void testRadio(){
		System.out.println("------测试radio成功----------");
	}
}
