package ExpelioPackage;

import com.microsoft.playwright.*;

import java.util.List;

public class Expelio {


    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.saucedemo.com");
        page.locator("#user-name").fill("standard_user");
        page.locator("#password").fill("secret_sauce");
        page.locator("#login-button").click();

        List<String> noOfProducts = page.locator("//div[@class='inventory_list']/div").allTextContents();
        System.out.println("noOfProducts: " + noOfProducts.size());

        page.locator("#add-to-cart-sauce-labs-backpack").click();
        page.locator("#add-to-cart-sauce-labs-bike-light").click();
        page.locator("#add-to-cart-sauce-labs-bolt-t-shirt").click();

        String badgeNo = page.locator(".shopping_cart_badge").textContent();
        System.out.println(badgeNo);

        page.close();

    }


}
