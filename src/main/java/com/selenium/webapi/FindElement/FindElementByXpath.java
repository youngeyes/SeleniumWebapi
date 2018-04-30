package com.selenium.webapi.FindElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 本类实现WebApi通过xpath定位元素
 * xpath定位元素比较简单，也比较方便，xpath路径不需要自己去写，
 * 利用浏览器开发者工具可以取得元素的xpath
 */
public class FindElementByXpath {
    public static void main(String args[]){
        WebDriver driver = new ChromeDriver();
        // 获取resources下静态文件的路径
        String filepath = FindElementByClassName.class.getResource("/static/find_element_by_xpath.html").getPath();
        String url = filepath.split("/",2)[1]; // 分割得到静态html文件的url
        driver.get(url);
        // xpath定位第一个input,相对路径
        WebElement element1 = driver.findElement(By.xpath("//input[1]"));
        element1.sendKeys("hello");
        // xpath绝对路径定位第二个input
        WebElement element2 = driver.findElement(By.xpath("/html/body/div/div/input[2]"));
        element2.sendKeys("world");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();

    }

}
