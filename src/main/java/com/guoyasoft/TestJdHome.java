package com.guoyasoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBys;

import com.guoyasoft.annotation.FindBySvc;
import com.guoyasoft.pages.BaiduDetail;
import com.guoyasoft.pages.BaiduHome;
import com.guoyasoft.pages.JdHomePage;
import com.guoyasoft.tools.BrowserEngine;

public class TestJdHome {
	public static void main(String[] args) {
		// 1. 打开浏览器
		WebDriver driver = BrowserEngine.startupChrome();
		try {
//			// 2. 实例化主界面
//			driver.get("https://www.jd.com");
//			JdHomePage home=FindBySvc.newPage(driver, JdHomePage.class);
//			// 3. 调用测试功能
//			home.search("iphone7");
			
			driver.get("http://www.baidu.com");
			BaiduHome baidu=FindBySvc.newPage(driver, BaiduHome.class);
			baidu.search("果芽软件");
			driver.findElement(By.partialLinkText("果芽软件"));
			BaiduDetail detail=FindBySvc.newPage(driver, BaiduDetail.class);
			detail.clickLink();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			BrowserEngine.shutdownChrome(driver);
		}
		// 4. 关闭浏览器
		BrowserEngine.shutdownChrome(driver);
	}
}
