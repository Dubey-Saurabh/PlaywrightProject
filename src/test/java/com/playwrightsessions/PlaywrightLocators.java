package com.playwrightsessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;

public class PlaywrightLocators {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext1 = browser.newContext();
        Page p1 = browserContext1.newPage();

/*        Single Element
        p1.navigate("https://www.instagram.com/");
        p1.locator("text=Mobile number, username or email").click();*/

/*        MultipleLocators
        p1.navigate("https://academy.naveenautomationlabs.com/");
        Locator LoginBtn = p1.locator("text=Login");
        LoginBtn.count();
        LoginBtn.first().click();*/

        p1.navigate("https://history.state.gov/countries/all");
        Locator listOfCountries = p1.locator("//*[@class='col-md-6']/div[1]/ul/li/a");
        System.out.println("List of countries: " +listOfCountries.count());

        //To iterate the elements one by one- Part1
        for (int i = 0; i < listOfCountries.count(); i++) {
            String countryNames = listOfCountries.nth(i).textContent();
            System.out.println("Country Name: " + countryNames);

        }

        //To iterate the elements one by one- Part2
        List<String> countriesList = listOfCountries.allTextContents();
        for(String eachCountryName : countriesList){
            System.out.println("Country Name: " + eachCountryName);
        }

        //To iterate the elements one by one- Part3
        countriesList.forEach(element -> System.out.println(element));

    }
}
