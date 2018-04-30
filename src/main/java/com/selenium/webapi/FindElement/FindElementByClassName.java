package com.selenium.webapi.FindElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

/**
 * 本类实现WebApi通过ClassName定位元素
 */
public class FindElementByClassName {
    public static void main(String args[]){
        WebDriver driver = new ChromeDriver();
        // 获取resources下静态文件的路径
        String filepath = FindElementByClassName.class.getResource("/static/find_element_by_classname.html").getPath();
        String url = filepath.split("/",2)[1]; // 分割得到静态html文件的url
        driver.get(url);
        WebElement element = driver.findElement(By.className("input-class"));
        element.sendKeys("classname");
        // 休眠2秒
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
