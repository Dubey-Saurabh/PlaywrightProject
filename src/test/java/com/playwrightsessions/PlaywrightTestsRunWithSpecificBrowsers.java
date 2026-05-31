package com.playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightTestsRunWithSpecificBrowsers {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setChannel("chrome");
        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        Page page = browser.newPage();

        page.navigate("https://www.playwright.com/");
        String title = page.title();
        System.out.println("Title would be:" +title);
        String url = page.url();
        System.out.println("Url would be:" +url);

        browser.close();
        playwright.close();


    }
}
