package com.selenium.webapi.FindElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 本类实现WebApi通过PartialLinkText定位元素
 */
public class FindElementByPartialLinkText {
    public static void main(String args[]){
        WebDriver driver = new ChromeDriver();
        // 获取resources下静态文件的路径
        String filepath = FindElementByClassName.class.getResource("/static/find_element_by_partial_linktext.html").getPath();
        String url = filepath.split("/",2)[1]; // 分割得到静态html文件的url
        driver.get(url);
        WebElement element = driver.findElement(By.partialLinkText("百度一下")); // 通过超链接的部分文本定位
        element.click(); // 点击超链接
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();

    }

}
