package com.playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class SelectingElementsWithinAnElementPart2 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.amazon.com/");
        List<String> strings = page.locator("div.navFooterLinkCol:has(a[href='https://services.amazon.com/sell.html?ld=AZFSSOA&ref_=footer_soa'])")
                .allInnerTexts();
        strings.forEach((element)->{System.out.println(element);
        });



    }
}
