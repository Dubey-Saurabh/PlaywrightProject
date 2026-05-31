package com.playwrightsessions;

import com.microsoft.playwright.*;

public class PlaywrightBrowserContexts {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext1 = browser.newContext();
        Page p1 = browserContext1.newPage();
        p1.navigate("https://www.instagram.com/");
        p1.fill("#_R_32d9lplcldcpbn6b5ipamH1_","Saurabh");
        System.out.println("Title would be:" +p1.title());

        BrowserContext browserContext2 = browser.newContext();
        Page p2 = browserContext2.newPage();
        p2.navigate("https://www.facebook.com");
        p2.fill("#_R_1h6kqsqppb6amH1_","Dubey");
        System.out.println("Title would be:" +p2.title());

        p1.close();
        browserContext1.close();

        p2.close();
        browserContext2.close();





    }

}
