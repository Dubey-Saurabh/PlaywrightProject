package com.playwrightsessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

import java.nio.file.Paths;

public class PlaywrightTracing {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();

            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));

            Page page = context.newPage();
            page.navigate("https://www.instagram.com/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create new account")).click();
            page.locator(".xjhjgkd").first().click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mobile number or email Mobile")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mobile number or email Mobile")).fill("9090898976");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password Password")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password Password")).fill("awefbgdfgdgsgsdhd");
            page.locator(".x9f619.x1ja2u2z.x78zum5").first().click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Name Full name")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Name Full name")).fill("svsrbebebsd");
            page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Username")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Name Full name")).fill("svsrbebebsdb");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("I already have an account")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Back")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Back")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create new account")).click();

            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
        }
    }
}
