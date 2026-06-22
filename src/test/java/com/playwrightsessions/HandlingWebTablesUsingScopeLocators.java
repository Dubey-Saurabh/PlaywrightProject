package com.playwrightsessions;

import com.microsoft.playwright.*;

public class HandlingWebTablesUsingScopeLocators {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practice.expandtesting.com/tables");

        Locator rowEditSelection = page.locator("#table1");
        String textOfRow = rowEditSelection.locator(":scope", new Locator.LocatorOptions().setHasText("Doe"))
                .locator("//table[@id='table1']//tr[3]/td").textContent();
        System.out.println(textOfRow);

        rowEditSelection.locator(":scope").allInnerTexts().forEach((e)->System.out.println(e));

    }
}
