package com.playwrightsessions;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class VideoRecording {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")).setRecordVideoSize(700,500));
        Page page = browserContext.newPage();
        page.navigate("https://academy.naveenautomationlabs.com/");

        // Click text=Login
        page.click("text=Login");

        browserContext.close();
        page.close();
        playwright.close();

    }
}