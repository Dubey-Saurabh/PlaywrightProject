package com.playwrightsessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import java.util.regex.Pattern;

public class PlaywrightInspectorRunWithDebugging {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.instagram.com/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create new account")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mobile number or email Mobile")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mobile number or email Mobile")).fill("9971378098");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password Password")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password Password")).fill("abc");
            page.locator(".x9f619.x1ja2u2z.x78zum5").first().click();
            page.getByLabel("Select Month").locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Month$"))).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password Password Show")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password Password Show")).fill("abceffwfwefwfwg4t2");
            page.locator(".x9f619.x1ja2u2z.x78zum5").first().click();
            page.getByLabel("Select Month").locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Month$"))).click();
            page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^July$"))).nth(1).click();
            page.getByLabel("Select Day").locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Day$"))).click();
            page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^5$"))).nth(1).click();
            page.getByLabel("Select Year").locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Year$"))).click();
            page.getByText("2020").click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Name Full name")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Name Full name")).fill("sgsgsgsg");
            page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Username")).click();
            page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Username")).fill("sgsgsgsg3754gsfsvs");
            page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Username")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("I already have an account")).click();
        }
    }
}
