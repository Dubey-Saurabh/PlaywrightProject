package com.playwrightsessions;

import com.microsoft.playwright.*;

public class FrameHandling {

    public static void main(String[] args) {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext1 = browser.newContext();
        Page page = browserContext1.newPage();
        page.navigate("https://docs.oracle.com/javase/8/docs/api/");
        page.frameLocator("//frame[@name='packageFrame']").locator("//a[text()='AbstractChronology']").click();


    }
}
