package com.playwrightsessions;

import com.microsoft.playwright.*;

public class JSAlertConfirmPrompt {

    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.onDialog(dialog -> {
            String promptText = dialog.message();
            System.out.println(promptText);
            dialog.accept("Saurabh is the name");

        });
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.click("//*[contains(text(),'Click for JS Alert')]");
        Thread.sleep(1500);
        page.click("//*[contains(text(),'Click for JS Confirm')]");
        Thread.sleep(1500);
        page.click("//*[contains(text(),'Click for JS Prompt')]");
        Thread.sleep(1500);

        String result = page.locator("#result").textContent();
        System.out.println(result);

        page.close();
        browserContext.close();
        playwright.close();


    }
}
