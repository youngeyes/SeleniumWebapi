package com.selenium.webapi.FindElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * 本类实现WebApi通过tagName定位元素
 */
public class FindElementByTagName {
    public static void main(String args[]) {
        WebDriver driver = new ChromeDriver();
        // 获取resources下静态文件的路径
        String filepath = FindElementByClassName.class.getResource("/static/find_element_by_tagname.html").getPath();
        String url = filepath.split("/",2)[1]; // 分割得到静态html文件的url
        driver.get(url);
        // 通过这种方式定位元素，如果有多个相同标签则只能定位到第一个元素
        WebElement element = driver.findElement(By.tagName("input"));
        element.sendKeys("first");
        // 如果想定位到多个元素，则使用findElements,返回List集合
        List<WebElement> elementlist = driver.findElements(By.tagName("input"));
        elementlist.get(1).sendKeys("second"); // 第二个input标签输入内容
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
