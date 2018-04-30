package com.selenium.webapi.ExcuteScript;

import com.selenium.webapi.FindElement.FindElementByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 本类实现WebApi执行JavaScript
 */
public class ExcuteJavaScript {
    public static  void main(String args[]){
        WebDriver driver = new ChromeDriver();
        // 获取resources下静态文件的路径
        String filepath = FindElementByClassName.class.getResource("/static/find_element_by_css.html").getPath();
        String url = filepath.split("/",2)[1]; // 分割得到静态html文件的url
        driver.get(url);
        // 编写JavaScript脚本，给每一个input标签设置内容
        String script = "var inputs = document.getElementsByTagName('input');" +
                "for(var i=0;i < inputs.length;i++){inputs[i].value = 'hello';}";
        ((ChromeDriver) driver).executeScript(script);
//        Object element = ((ChromeDriver) driver).executeScript(script);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
