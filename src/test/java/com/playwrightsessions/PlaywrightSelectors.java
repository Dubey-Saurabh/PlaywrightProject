package com.playwrightsessions;

import com.microsoft.playwright.*;

public class PlaywrightSelectors {

    public static void main(String[] args) {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));


        Page page = browser.newPage();
        page.navigate("https://www.instagram.com/");

//        Using Normal text
        page.locator("text=Create new account").click();

/*        When multiple elements of same name
        Locator instagramLite = page.locator("text=Instagram");
        System.out.println(instagramLite.count());

        for (int i = 0; i < instagramLite.count(); i++) {
           String text=  instagramLite.textContent();
           if (text.equals("Instagram Lite")){
                      instagramLite.click();
                      break;
           }
        }*/

/*        using has text method

        String value = page.locator("div label:has-text('Mobile number or email')").textContent();
        System.out.println(value);*/


    }
}
