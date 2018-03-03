package com.guoyasoft.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.guoyasoft.pages.JdHomePage;

public class FindBySvc {
	public static <T> T newPage(WebDriver driver,Class<T> jdClass) throws Exception{
		//new一个实例
		Constructor<T> constructor=jdClass.getConstructor(WebDriver.class);
		T jd=constructor.newInstance(driver);
		
		//将findby标准的元素全部查到，并赋值给对应字段
		 List<Field> fields = getAllFields(jdClass);
		 for (Field f : fields) {
	            FindBy findBy = f.getAnnotation(FindBy.class);
	            if (findBy != null) {
	                if (WebElement.class.getName().equals(f.getType().getName())) {
	                    WebElement element = getElement(driver, findBy);
	                    f.set(jd, element);
	                }
	            }
	        }
		return jd;
	}
	
    private static WebElement getElement(WebDriver driver, FindBy findBy) {
        WebElement element = null;
        if (!"".equals(findBy.xpath())) {
            element = driver.findElement(By.xpath(findBy.xpath()));
        } else if (!"".equals(findBy.id())) {
            element = driver.findElement(By.id(findBy.id()));
        } else if (!"".equals(findBy.name())) {
            element = driver.findElement(By.name(findBy.name()));
        }else if(!"".equals(findBy.partialLinkText())){
        	element=driver.findElement(By.partialLinkText(findBy.partialLinkText()));
        }
        return element;
    }
    public static List<Field> getAllFields(Class page) {
        List<Field> list = new ArrayList<Field>();
        Class tempClass = page;
        while (tempClass != null) {// 当父类为null的时候说明到达了最上层的父类(Object类).
            list.addAll(Arrays.asList(tempClass.getDeclaredFields()));
            tempClass = tempClass.getSuperclass(); // 得到父类,然后赋给自己
        }
        return list;
    }
}
