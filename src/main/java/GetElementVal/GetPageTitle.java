package GetElementVal;

import com.selenium.webapi.FindElement.FindElementByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 本类实现获取网页title的值
 */
public class GetPageTitle {
    public static void main(String args[]){
        WebDriver driver = new ChromeDriver();
        // 获取resources下静态文件的路径
        String filepath = FindElementByClassName.class.getResource("/static/webapi_test.html").getPath();
        String url = filepath.split("/",2)[1]; // 分割得到静态html文件的url
        driver.get(url);
        String title = driver.getTitle();
        System.out.println(title);
        driver.close();
    }
}
