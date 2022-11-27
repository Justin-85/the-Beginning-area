package com.example.tool;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.vo.YouTubeVo;

public class ChromeSpider {
      
    /**
     * 瀏覽器設定、拜訪網頁
     * 
     */
    public static WebDriver getDriver(String chromeDriverPath, String url) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("–headless");  // 不開啟實體瀏覽器背景執行
        options.addArguments("–start-maximized");  // 最大化視窗
        options.addArguments("–incognito");  // 開啟無痕模式
        options.addArguments("–disable-popup-blocking");  // 禁用彈出攔截
        
        WebDriver driver = new ChromeDriver(options);
                
//        driver.manage().window().maximize(); // 瀏覽器畫面最大
        
        driver.get(url);
        return driver;
    }
    
    /**
     * 輸入查詢 (for youtube)
     * @throws InterruptedException 
     * 
     */    
    public static void search(WebDriver driver, String keyWord, String filter) throws InterruptedException {
        
        new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#search")));
        
        WebElement element = driver.findElement(By.cssSelector("input#search")); // 找到搜尋 input 欄位
        element.sendKeys(keyWord); // 输入内容  
        new WebDriverWait(driver, 100).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search-icon-legacy")));
        element = driver.findElement(By.id("search-icon-legacy")); // 找到搜尋 button 按鈕
        element.click();
        
        // 篩選器
        new WebDriverWait(driver, 100).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#container ytd-toggle-button-renderer button")));
        element = driver.findElement(By.cssSelector("#container ytd-toggle-button-renderer button"));
        element.click();
        Thread.sleep(1000); 
        element = driver.findElement(By.partialLinkText(filter));
        element.click();
    }    
    
    /**
     * 滾動頁面
     * @throws InterruptedException 
     * 
     */     
    public static void scroll(WebDriver driver, int perScroll, int maxScroll) throws InterruptedException {
        int height = 0;
        
        while(height <= maxScroll) {
            String doScroll = "window.scrollBy(" + String.valueOf(height) + "," + String.valueOf(height + perScroll) + ")";
            ((JavascriptExecutor) driver).executeScript(doScroll); // ex. window.scrollBy(0, 700)
            height += perScroll;
            Thread.sleep(2000); 
        }
    }
    
    /**
     * 分析頁面元素資訊
     * @throws InterruptedException 
     * 
     */      
    public static List<YouTubeVo> getContentList(WebDriver driver) {
        List<WebElement> listWebElement = driver.findElements(By.cssSelector(".style-scope ytd-video-renderer")); // 取得主要元素的集合
        List<YouTubeVo> list = new ArrayList<YouTubeVo>();
        
        for(WebElement element : listWebElement) {
            YouTubeVo youTube = new YouTubeVo();

            // title
            String title = element.findElement(By.cssSelector("a#video-title")).getAttribute("title");
            // imgSrc
            String imgSrc = element.findElement(By.cssSelector("ytd-thumbnail.style-scope.ytd-video-renderer img#img")).getAttribute("src");
            // link
            String link = element.findElement(By.cssSelector("a#video-title")).getAttribute("href");            
            // id
            String id = link.split("v=")[1];
                 
            youTube.setId(id);
            youTube.setTitle(title);
            youTube.setImgSrc(imgSrc);
            youTube.setLink(link);

            list.add(youTube);
        }
        return list;
    }
    
    
}
