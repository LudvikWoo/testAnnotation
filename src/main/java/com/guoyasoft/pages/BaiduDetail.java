package com.guoyasoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.guoyasoft.annotation.FindBy;
import com.guoyasoft.tools.BasePage;

public class BaiduDetail extends BasePage {
	
	public BaiduDetail(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(partialLinkText="果芽软件")
	public WebElement link;
	
	public void clickLink(){
		click(link);
	}
}
