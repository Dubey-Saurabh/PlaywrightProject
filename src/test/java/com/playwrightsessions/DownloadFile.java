package com.playwrightsessions;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class DownloadFile {

    public static void main(String[] args) {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=102.0.5005.27/");

        Download download = page.waitForDownload(()->{
           page.click("a:text('chromedriver_mac64.zip')");
        });

        //Source url of downloaded file
        System.out.println(download.url());

        //Save a file with renaming it
        download.saveAs(Paths.get("Saurabh_chrome.zip"));

    }
}
