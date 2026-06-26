package com.playwrightsessions;

import com.microsoft.playwright.*;

public class HandleBrowserWindows {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.instagram.com/");
//        Page popUp = page.waitForPopup(()->{
//
//            page.click("//*[text()='Meta']");
//
//        });
//        popUp.waitForLoadState();
//        System.out.println("Title of new opened window: "+popUp.title());
//        popUp.close();
//        System.out.println("Title of Original Page: "+page.title());
//        page.close();

        //Open a new tab and enter a url
        Page popUp = page.waitForPopup(() -> {

            page.click("a[target='_blank']");

        });
        popUp.waitForLoadState();
        popUp.navigate("https://www.facebook.com/");
        System.out.println("Title of new opened window: " + popUp.title());
        popUp.close();
        System.out.println("Title of Original Page: " + page.title());
        page.close();


    }
}
