package com.guoyasoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.guoyasoft.annotation.FindBy;
import com.guoyasoft.tools.BasePage;

public class BaiduHome extends BasePage{
	public BaiduHome(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//*[@id='kw']")
	public WebElement input;
	
	@FindBy(xpath="//*[@id='su']")
	public WebElement search;

	
	public void search(String content){
		text(input, content);
		click(search);
	}
}
