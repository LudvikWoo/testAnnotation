package com.guoyasoft.tools;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	// 公共属性
	public WebDriver driver;
	public String pageTitle;
	public String pageUrl;

	/*
	 * 构造方法
	 */
	protected BasePage(WebDriver driver) {
		this.driver = driver;
		this.pageUrl = driver.getCurrentUrl();
		this.pageTitle = driver.getTitle();
	}

	/*
	 * 在文本框内输入字符
	 */
	protected void text(WebElement element, String text) {
		try {
			if (element.isEnabled()) {
				element.clear();
				System.out.println("Clean the value if any in "
						+ element.toString() + ".");
				element.sendKeys(text);
				System.out.println("Type value is: " + text + ".");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 点击元素，这里指点击鼠标左键
	 */
	protected void click(WebElement element) {

		try {
			if (element.isEnabled()) {
				element.click();
				System.out.println("Element: " + element.toString()
						+ " was clicked.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void switchToNextWindow() {

		String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
		Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄
		System.out.println("当前窗口数量： " + handles.size());
		for (String s : handles) {
			if (currentWindow.endsWith(s)) {
				continue;
			} else {
				try {
					WebDriver window = driver.switchTo().window(s);// 切换到新窗口
					System.out
							.println("new page title is " + window.getTitle());
					break;
				} catch (Exception e) {
					System.out.println("法切换到新打开窗口" + e.getMessage());

				}
			}
		}

	}

	public void switchToTitleWindow(String windowTitle) {
		// 将页面上所有的windowshandle放在入set集合当中
		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String s : handles) {
			driver.switchTo().window(s);
			// 判断title是否和handles当前的窗口相同
			if (driver.getTitle().contains(windowTitle)) {
				break;// 如果找到当前窗口就停止查找
			}
		}
	}
}
