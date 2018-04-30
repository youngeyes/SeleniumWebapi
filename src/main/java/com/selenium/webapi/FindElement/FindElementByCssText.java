package com.selenium.webapi.FindElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 本类实现WebApi通过LinkText定位元素
 */
public class FindElementByCssText {
    public static void main(String args[]){
        WebDriver driver = new ChromeDriver();
        // 获取resources下静态文件的路径
        String filepath = FindElementByClassName.class.getResource("/static/find_element_by_css.html").getPath();
        String url = filepath.split("/",2)[1]; // 分割得到静态html文件的url
        driver.get(url);
        // 1.cssSelector Id定位元素,用“#”后面跟Id名的方式
        WebElement element1 = driver.findElement(By.cssSelector("#in1"));
        element1.sendKeys("css id"); // 输入内容
        // 2.cssSelector class定位元素,用“.”后面跟class名的方式
        WebElement element2 = driver.findElement(By.cssSelector(".in2"));
        element2.sendKeys("css class");
        // 3.cssSelector 复合class定位元素,多个class之间用“.”
        WebElement element3 = driver.findElement(By.cssSelector("input.pi.px.pd"));
        element3.sendKeys("css class多个");
        // 4.cssSelector 层级定位，多层以空格隔开，往往通过标签名明确指定css
        WebElement element4 = driver.findElement(By.cssSelector("div#main div#input-div input.pi"));
        element4.sendKeys("css 多层嵌套");
        // 5.cssSelector 根据元素属性定位
        WebElement element5 = driver.findElement(By.cssSelector("input[name='third']")); // 单属性
        element5.sendKeys("css 单属性");
        WebElement element6 = driver.findElement(By.cssSelector("input[name='third'][attr='attr']")); // 多属性
        element6.sendKeys("css 多属性");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();

    }

}
