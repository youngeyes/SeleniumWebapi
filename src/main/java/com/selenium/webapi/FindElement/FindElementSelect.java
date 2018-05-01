package com.selenium.webapi.FindElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * 本类实现select标签的选择
 */
public class FindElementSelect {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        // 获取resources下静态文件的路径
        String filepath = FindElementByClassName.class.getResource("/static/find_element_select.html").getPath();
        String url = filepath.split("/",2)[1]; // 分割得到静态html文件的url
        driver.get(url);
        WebElement element = driver.findElement(By.id("select")); // 1.定位到select元素
        Select select = new Select(element); // 实例化Select对象，传入element

        //select.selectByIndex(1); // 通过index选择
        //select.selectByValue("1");// 通过value值选择
        select.selectByVisibleText("选项2"); // 通过Text选择

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
