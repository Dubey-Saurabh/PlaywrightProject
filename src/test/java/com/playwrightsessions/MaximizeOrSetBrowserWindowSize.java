package com.playwrightsessions;

import com.microsoft.playwright.*;

public class MaximizeOrSetBrowserWindowSize {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(640, 480));
        Page page = browserContext.newPage();
        page.navigate("https://www.instagram.com/");
        page.waitForLoadState();
        System.out.println(page.title());
        page.close();
        browserContext.close();
        playwright.close();

    }
}
