package br.pb.thiagofb84jp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class TesteFirefox {
    public static void main(String[] args) {
        try {
            FirefoxOptions ops = new FirefoxOptions();
            ops.setBinary("/usr/lib/firefox/firefox");
            FirefoxDriver driver = new FirefoxDriver(ops);
//            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://www.google.com");

            Thread.sleep(5000);
            System.out.println(driver.getTitle());

            driver.close();
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
}