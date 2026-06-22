package com.playwrightsessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUpload {

    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext1 = browser.newContext();
        Page page = browserContext1.newPage();
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

        //Select one file
        page.setInputFiles("input#filesToUpload", Paths.get("trace.zip"));
        Thread.sleep(4000);
        //To deselect uploaded file
        page.setInputFiles("input#filesToUpload", new Path[0]);

        //Multiple files
        page.setInputFiles("input#filesToUpload", new Path[]{Paths.get("trace.zip"),
                Paths.get("pom.xml"),
                Paths.get("trace.zip")});
        page.setInputFiles("input#filesToUpload", new Path[0]);

        BrowserContext browserContext2 = browser.newContext();
        page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");

        //When you create a file in runtime and want to upload
        page.setInputFiles("input[name='upfile']", new FilePayload("saurabh.txt","text/plain", "Saurabh Dubey is the name".getBytes(StandardCharsets.UTF_8)));
        page.click("input[value='Press']");

        page.close();
        browserContext1.close();
        browserContext2.close();

    }
}
