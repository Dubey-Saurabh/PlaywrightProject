package com.playwrightsessions;

import com.microsoft.playwright.*;

import java.util.List;

public class SelectingElementsWithinAnElementPart1 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://orangehrm.com/30-day-free-trial");
        List<String> strings = page.locator("select#Form_getForm_Country:has(option[value='India'])").allInnerTexts();
        strings.forEach((element)->{System.out.println(element);
        });



    }
}
