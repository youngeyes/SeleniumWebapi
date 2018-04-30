package com.selenium.webapi.FindElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 本类实现WebApi通过Id定位元素
 */
public class FindElementById {
    public static  void main(String args[]) {
        WebDriver driver = new ChromeDriver(); // 初始化WebDriver，用ChromeDriver驱动
        driver.get("http://www.baidu.com"); // 要访问的url地址
        WebElement element = driver.findElement(By.id("kw")); // 通过By.id定位元素-搜索框
        element.sendKeys("selenium"); // 向输入框输入
        WebElement element1 = driver.findElement(By.id("su")); // 通过By.id定位元素-百度一下按钮
        element1.click(); // 点击百度一下按钮
        driver.close(); // 关闭浏览器
    }
}
