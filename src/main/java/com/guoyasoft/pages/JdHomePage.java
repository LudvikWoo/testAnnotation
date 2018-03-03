package com.guoyasoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.guoyasoft.annotation.FindBy;
import com.guoyasoft.tools.BasePage;

public class JdHomePage extends BasePage{

	public JdHomePage(WebDriver driver) {
		super(driver);
	}

	/*
	 * 定义元素
	 */
	//查询输入框
	@FindBy(id="key")
	public WebElement input;
	
	//查询按钮
	@FindBy(xpath="//*[@id='search']/div/div[2]/button")
	public WebElement searchBtn;
	
	//定义功能
	public void search(String content){
		text(input, content);
		click(searchBtn);
	}
}
