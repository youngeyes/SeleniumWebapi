package com.selenium.webapi.SwitchToOperation;

import com.selenium.webapi.FindElement.FindElementByClassName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

/**
 * 本类实现window切换
 */
public class SwitchToWindow {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        // 获取resources下静态文件的路径
        String filepath = FindElementByClassName.class.getResource("/static/switch_to_window.html").getPath();
        String url = filepath.split("/", 2)[1]; // 分割得到静态html文件的url
        driver.get(url);
        // 定位超连接，点击
        WebElement element1 = driver.findElement(By.id("baidu"));
        element1.click();
        String currentHand = driver.getWindowHandle(); // 获取当前窗口句柄
        Set<String> hands = driver.getWindowHandles(); // 获取所有窗口句柄
        Iterator<String> item = hands.iterator();
        while (item.hasNext()) {
            String hand = item.next(); // 获取窗口句柄并保存
            if (!hand.equals(currentHand)) { // 如果窗口句柄不等于当前窗口句柄，则切换窗口
                driver.switchTo().window(hand);
                WebElement element2 = driver.findElement(By.id("kw")); // 定位新窗口的元素
                element2.sendKeys("selenium");
            }
        }
        driver.switchTo().window(currentHand); // 回到当前主窗口
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close(); // 只会关闭当前窗口,若要关闭浏览器则使用 driver.quit();
        //driver.quit();

    }
}
