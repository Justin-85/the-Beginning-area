package com.example;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.example.tool.ChromeSpider;
import com.example.vo.YouTubeVo;

public class Selenium {

    public static void main(String[] args) throws InterruptedException {
        String chromeDriverPath = "C:\\Users\\WORK\\Desktop\\chromedriver.exe";
        String url = "https://www.youtube.com/";
        String keyWord = "茄子蛋";
        String filter = "4 分鐘內"; // 4 分鐘內, 4 至 20 分鐘, 超過 20 分鐘, 今天, 本週...
        
        WebDriver driver = ChromeSpider.getDriver(chromeDriverPath, url);
        // 爬取資料
        ChromeSpider.search(driver, keyWord, filter);
        ChromeSpider.scroll(driver, 100, 200);
        List<YouTubeVo> list = ChromeSpider.getContentList(driver);
        driver.close();

        // 使用 cmd 執行 youtube-dl.exe 下載檔案
        Runtime run = Runtime.getRuntime(); 
        for (YouTubeVo yt : list) {
            String cmd = ".\\yt-dlp.exe -f mp4 -i " + yt.getLink() + " -o " + yt.getId() + ".mp4";
            try {
                Process process = run.exec("cmd.exe /c start " + cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    

    
    
    
}
