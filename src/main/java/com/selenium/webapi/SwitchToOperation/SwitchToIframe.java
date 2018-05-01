package com.selenium.webapi.SwitchToOperation;

import com.selenium.webapi.FindElement.FindElementByClassName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 本类实现iframe之间的切换
 */
public class SwitchToIframe {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        // 获取resources下静态文件的路径
        String filepath = FindElementByClassName.class.getResource("/static/switch_to_frame.html").getPath();
        String url = filepath.split("/", 2)[1]; // 分割得到静态html文件的url
        driver.get(url);
        // 1.点击按钮，进入父iframe
        WebElement element1 = driver.findElement(By.id("btn1"));
        element1.click();
        // 2.操作父iframe中的元素,这时候需要切换到父iframe中才能定位父iframe中的元素
        driver.switchTo().frame("parent-iframe"); // 切换到父iframe,方法1：直接使用iframe的id切换
//        driver.switchTo().frame("pframe"); // 方法2：直接使用iframe的name切换
//        WebElement elementPframe = driver.findElement(By.tagName("iframe"));
//        driver.switchTo().frame(elementPframe); // 方法3：如果没有id或name，通过其他方法先定位到iframe然后切换
        WebElement element2 = driver.findElement(By.xpath("/html/body/input[1]"));
        element2.sendKeys("这是父iframe输入框");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 3.点击进入子iframe
        WebElement element3 = driver.findElement(By.id("btn2"));
        element3.click();
        // 4.操作子iframe中的元素
        driver.switchTo().frame("child-iframe");
        WebElement element4 = driver.findElement(By.id("in1"));
        element4.sendKeys("这是子iframe输入框");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 5.切回到父iframe
        driver.switchTo().parentFrame();
        WebElement element5 = driver.findElement(By.xpath("/html/body/input[2]"));
        element5.sendKeys("这是父iframe第二个输入框");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 6.切回到默认页面
        driver.switchTo().defaultContent();
        WebElement element6 = driver.findElement(By.id("text"));
        element6.sendKeys("这是默认页面输入框");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();

    }
}
