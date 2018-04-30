package com.selenium.webapi.GetElementVal;

import com.selenium.webapi.FindElement.FindElementByClassName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 本类实现获取元素Text的值
 */
public class GetElementText {
    public static void main(String args[]){
        WebDriver driver = new ChromeDriver();
        // 获取resources下静态文件的路径
        String filepath = FindElementByClassName.class.getResource("/static/webapi_test.html").getPath();
        String url = filepath.split("/",2)[1]; // 分割得到静态html文件的url
        driver.get(url);
        WebElement element = driver.findElement(By.cssSelector("#main > div.body > form > div:nth-child(3) > label"));
        String text = element.getText(); // 获取label标签的Text
        System.out.println(text);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element1 = driver.findElement(By.cssSelector("#main > div.card-body > a:nth-child(1)"));
        String aText = element1.getText(); // 获取a标签的Text
        System.out.println(aText);
        driver.close();
    }
}
