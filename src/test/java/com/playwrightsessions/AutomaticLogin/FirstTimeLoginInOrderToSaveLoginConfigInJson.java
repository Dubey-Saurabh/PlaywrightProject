package com.playwrightsessions.AutomaticLogin;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class FirstTimeLoginInOrderToSaveLoginConfigInJson {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://practicetestautomation.com/practice-test-login/");
        page.fill("#username", "student");
        page.fill("#password", "Password123");
        page.click("#submit");

        browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));


    }
}
